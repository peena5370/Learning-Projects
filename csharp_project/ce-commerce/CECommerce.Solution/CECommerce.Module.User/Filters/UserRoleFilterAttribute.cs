
using CECommerce.Utility.Logging;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace CECommerce.Module.User.Filters
{
    public class UserRoleFilterAttribute : TypeFilterAttribute
    {
        public UserRoleFilterAttribute() : base(typeof(UserRoleFilter)) { }
    }
}
