
using CECommerce.Utility.Logging;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace CECommerce.Module.User.Filters
{
    public class UserRoleFilter(ILogHelper log) : IActionFilter, IAsyncActionFilter
    {
        private readonly ILogHelper _log = log;
        public void OnActionExecuting(ActionExecutingContext context)
        {
            _log.LogInfo<UserRoleFilter>("UserRoleFilter: Action is executing.");
        }
        public void OnActionExecuted(ActionExecutedContext context)
        {
            _log.LogInfo<UserRoleFilter>("UserRoleFilter: Action is executed.");
        }
        public async Task OnActionExecutionAsync(ActionExecutingContext context, ActionExecutionDelegate next)
        {
            _log.LogInfo<UserRoleFilter>("UserRoleFilter: Action is executing.");

            var authorization = context.HttpContext.Request.Headers.TryGetValue("Authorization", out var token);
            if (!authorization || string.IsNullOrEmpty(token) || !token.ToString().StartsWith("Bearer "))
            {
                _log.LogWarning<UserRoleFilter>("UserRoleFilter: Unauthorized access attempt.");
                context.Result = new UnauthorizedResult();
                return;
            }

            await next();

            _log.LogInfo<UserRoleFilter>("UserRoleFilter: Action is executed.");
        }
    }
}
