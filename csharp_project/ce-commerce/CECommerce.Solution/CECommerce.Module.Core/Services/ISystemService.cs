using CECommerce.Module.Core.Models;
using CECommerce.Module.User.Models;

namespace CECommerce.Module.Core.Services
{
    public interface ISystemService
    {
        Task<LoginResponse> ValidateAccountAsync(string service, LoginDTO? loginDto);
    }
}
