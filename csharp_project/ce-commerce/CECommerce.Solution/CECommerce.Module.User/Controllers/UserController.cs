using CECommerce.Utility.Logging;
using Microsoft.AspNetCore.Mvc;

namespace CECommerce.Module.User.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    internal class UserController(ILogHelper log) : ControllerBase
    {
        private readonly ILogHelper _log = log;

        [HttpPost]
        public async Task<IActionResult> CreateUser(string serviceType, [FromBody] string body)
        {
            switch(serviceType)
            {
                case "AdminService":
                    _log.LogInfo<UserController>("CreateUser: Admin service is being used for user creation.");
                    break;
                case "SellerService":
                    _log.LogInfo<UserController>("CreateUser: Seller service is being used for user creation.");
                    break;
                case "BuyerService":
                    _log.LogInfo<UserController>("CreateUser: Buyer service is being used for user creation.");
                    break;
                default:
                    string message = $"CreateUser: Unknown service type {serviceType} provided.";
                    _log.LogWarning<UserController>(message);
                    return BadRequest(new { Message = "Unknown service type." });
            }


            return Ok(new { Message = "success" });
        }
    }
}
