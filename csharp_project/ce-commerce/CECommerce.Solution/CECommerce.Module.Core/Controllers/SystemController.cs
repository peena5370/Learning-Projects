using CECommerce.Module.Core.Models;
using CECommerce.Module.Core.Services;
using CECommerce.Module.User.Models;
using CECommerce.Module.User.Services;
using CECommerce.Utility.Helpers;
using CECommerce.Utility.Logging;
using Microsoft.AspNetCore.Mvc;

namespace CECommerce.Module.User.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SystemController(ILogHelper log, ISystemService systemService, IUserService userService) : ControllerBase
    {
        private readonly ILogHelper _log = log;
        private readonly ISystemService _systemService = systemService;
        private readonly IUserService _userService = userService;

        [HttpPost("authenticate")]
        public async Task<IActionResult> Login(string service, [FromBody] LoginDTO? loginDto)
        {
            switch (service)
            {
                case "AdminLogin":
                    _log.LogInfo<SystemController>("Login: Admin service is being used for authentication.");
                    break;
                case "SellerLogin":
                case "SellerLoginMobile":
                    _log.LogInfo<SystemController>("Login: Seller service is being used for authentication.");
                    break;
                case "BuyerLogin":
                case "BuyerLoginMobile":
                    _log.LogInfo<SystemController>("Login: Buyer service is being used for authentication.");
                    break;
                default:
                    string message = $"Login: Unknown service type {service} provided.";
                    _log.LogWarning<SystemController>(message);
                    return BadRequest(new { Message = "Unknown service type." });
            }


            // Simulate a login process
            object[] param = { "nothing1", "password2", service };
            _log.LogInfo<SystemController>("Login: Attempting to authenticate user.{0}, {1}, {2}", param);

            _userService.TestMethod();

            var login = new LoginDTO
            (
                loginDto?.Username ?? "defaultUser",
                loginDto?.Password ?? "defaultPassword",
                loginDto?.RememberMe ?? false
            );

            byte[] salt = PasswordHelper.GenerateSecretKey();
            string encryptedPassword = PasswordHelper.EncryptPassword("Test@Password", salt);
            _log.LogInfo<SystemController>("Login: Encrypted password is {encryptedPassword}", encryptedPassword);
            bool isPasswordValid = PasswordHelper.VerifyPassword("Test@Password", encryptedPassword);

            LoginResponse result = await _systemService.ValidateAccountAsync(service, loginDto);
            if (result == null)
            {
                _log.LogWarning<SystemController>("Login: User authentication failed for username {username}.", null);
            }

            return Ok(new { Message = "success" });
        }

        [HttpPost("logout")]
        public async Task<IActionResult> Logout(string service)
        {
            //Simulate a logout process
            //_log.LogInformation("Logout: User logged out successfully.");

            switch (service)
            {
                case "AdminLogin":
                    _log.LogInfo<SystemController>("Login: Admin service is being used for authentication.");
                    break;
                case "SellerLogin":
                case "SellerLoginMobile":
                    _log.LogInfo<SystemController>("Login: Seller service is being used for authentication.");
                    break;
                case "BuyerLogin":
                case "BuyerLoginMobile":
                    _log.LogInfo<SystemController>("Login: Buyer service is being used for authentication.");
                    break;
                default:
                    string message = $"Login: Unknown service type {service} provided.";
                    _log.LogWarning<SystemController>(message);
                    return BadRequest(new { Message = "Unknown service type." });
            }

            return Ok(new { Message = "success" });
        }
    }
}
