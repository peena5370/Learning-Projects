using CECommerce.Module.Core.Models;
using CECommerce.Module.User.Context;
using CECommerce.Module.User.Models;
using CECommerce.Module.User.Services;
using CECommerce.Utility.Logging;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;

namespace CECommerce.Module.Core.Services
{
    public class SystemService(ILogHelper log, UserContext userContext) : ISystemService
    {
        private readonly ILogHelper _log = log;
        private readonly UserContext _userContext = userContext;
        public async Task<LoginResponse> ValidateAccountAsync(string service, LoginDTO? loginDto)
        {
            LoginResponse response = new();

            switch(service)
            {
                case "AdminLogin":
                    // _log.LogInformation("Admin service is being used for authentication.");
                    break;
                case "SellerLogin":
                case "SellerLoginMobile":
                    // _log.LogInformation("Seller service is being used for authentication.");
                    break;
                case "BuyerLogin":
                case "BuyerLoginMobile":
                    // _log.LogInformation("Buyer service is being used for authentication.");
                    break;
                default:
                    // _log.LogWarning("Unknown service type {service} provided.", service);
                    return null;
            }

            //var userAccount = await _userContext.UserAccounts.Where(x => x.Username == loginDto.Username).FirstOrDefaultAsync();

            //if (userAccount != null)
            //{
            //    _log.LogInformation("User account with username {username} found.", loginDto.Username);
            //}
            //else
            //{
            //    _log.LogWarning("User account with username {username} not found.", loginDto.Username);
            //}

            return response;
        }
    }
}
