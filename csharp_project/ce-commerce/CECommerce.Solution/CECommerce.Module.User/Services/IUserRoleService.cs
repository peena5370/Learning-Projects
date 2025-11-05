
using CECommerce.Module.User.Models;

namespace CECommerce.Module.User.Services
{
    public interface IUserRoleService
    {
        Task<int> CreateRoleAsync(UserRoleDTO role);
        Task<UserRoleResponse?> GetRoleByIdAsync(long id);
        Task<int> UpdateRoleAsync(long id, long uid, UserRoleDTO role);
        Task<int> DeleteRoleAsync(long id);
        Task<IEnumerable<UserRoleDAO>> ListRolesAsync(int offset = 0, int limit = 5);
    }
}
