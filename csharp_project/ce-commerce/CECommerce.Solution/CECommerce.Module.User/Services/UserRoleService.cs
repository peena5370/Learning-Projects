using CECommerce.Module.User.Context;
using CECommerce.Module.User.Models;
using CECommerce.Utility.Configurations;
using CECommerce.Utility.Helpers;
using CECommerce.Utility.Logging;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;

namespace CECommerce.Module.User.Services
{
    public class UserRoleService(ILogHelper log, UserContext context, IOptions<SnowflakeSettings> settings, ICacheHelper cache) : IUserRoleService
    {
        private readonly ILogHelper _log = log;
        private readonly UserContext _context = context;
        private readonly SnowflakeSettings _settings = settings.Value;
        private readonly ICacheHelper _cache = cache;

        public async Task<int> CreateRoleAsync(UserRoleDTO role)
        {
            int result;
            SnowflakeIdGenerator generator = new(_settings.DataCenterId, _settings.WorkerId);

            var existingRole = await _context.UserRoles
                .FirstOrDefaultAsync(r => r.RoleName.ToLower() == role.RoleName.ToLower());

            if (existingRole != null)
            {
                result = 400;
            }
            else
            {
                var newRole = new UserRoleDAO
                {
                    RoleId = generator.NextId(),
                    RoleName = role.RoleName,
                    IsActive = role.IsActive,
                    ModifiedAt = DateTime.UtcNow,
                };

                _context.UserRoles.Add(newRole);

                result = await _context.SaveChangesAsync();

                _log.LogInfo<UserRoleService>($"CreateRoleAsync: Created role with ID {newRole.RoleId} and name {newRole.RoleName}. Status: {result}");
            }

            return result;
        }

        public async Task<int> DeleteRoleAsync(long id)
        {
            int result;
            var role = await _context.UserRoles.FirstOrDefaultAsync(r => r.RoleId == id);

            if (role == null)
            {
                _log.LogInfo<UserRoleService>($"DeleteRoleAsync: Role with ID {id} not found.");
                result = 404; // Not Found
            }
            else
            {
                _context.UserRoles.Remove(role);
                result = await _context.SaveChangesAsync();

                _cache.Remove($"UserRole_{id}");
                _log.LogInfo<UserRoleService>($"DeleteRoleAsync: Deleted role with ID {id}. Status: {result}");
            }

            return result;
        }

        public async Task<UserRoleResponse?> GetRoleByIdAsync(long id)
        {
            UserRoleResponse? result = null;

            var userRole = await _cache.GetOrSetAsync(
                $"UserRole_{id}",
                async () =>
                {
                    _log.LogInfo<UserRoleService>($"GetRoleByIdAsync: Fetching role with ID {id} from database.");
                    return await _context.UserRoles.FirstOrDefaultAsync(r => r.RoleId == id);
                },
                expiration: TimeSpan.FromMinutes(5),
                slidingExpiration: TimeSpan.FromMinutes(2));

            if (userRole != null)
            {
                _log.LogInfo<UserRoleService>($"GetRoleByIdAsync: Found role with ID {id}.");
                result = new UserRoleResponse
                {
                    Id = userRole.RoleId,
                    RoleName = userRole.RoleName,
                    IsActive = userRole.IsActive,
                    ModifiedDate = userRole.ModifiedAt
                };
            }

            return result;
        }

        public Task<IEnumerable<UserRoleDAO>> ListRolesAsync(int offset = 0, int limit = 5)
        {
            throw new NotImplementedException();
        }

        public async Task<int> UpdateRoleAsync(long id, long uid, UserRoleDTO role)
        {
            int result;
            var existingRole = await _context.UserRoles.FirstOrDefaultAsync(r => r.RoleId == id);

            if (existingRole == null)
            {
                _log.LogInfo<UserRoleService>($"UpdateRoleAsync: Role with ID {id} not found.");
                result = 404;
            }
            else
            {
                var sameNameRole = await _context.UserRoles
                    .FirstOrDefaultAsync(r => r.RoleName.ToLower() == role.RoleName.ToLower());

                if (sameNameRole != null && sameNameRole.RoleId != id)
                {
                    _log.LogInfo<UserRoleService>($"UpdateRoleAsync: Role with name {role.RoleName} already exists.");
                    result = 400;
                }
                else
                {
                    result = await _context.UserRoles.Where(r => r.RoleId == existingRole.RoleId)
                    .ExecuteUpdateAsync(r => r
                    .SetProperty(u => u.RoleName, role.RoleName)
                    .SetProperty(u => u.IsActive, role.IsActive)
                    .SetProperty(u => u.ModifiedAt, DateTime.UtcNow)
                    .SetProperty(u => u.ModifiedBy, uid));

                    _cache.Remove($"UserRole_{id}");

                    _log.LogInfo<UserRoleService>($"UpdateRoleAsync: Updated role with ID {id}. Status: {result}");
                }
            }

            return result;
        }
    }
}
