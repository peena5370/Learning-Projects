
namespace CECommerce.Module.Core.Models
{
    public class LoginResponse
    {
        public bool IsSuccess { get; set; }
        public string? Message { get; set; }
        public TokenResponse? Token { get; set; }
    }
}
