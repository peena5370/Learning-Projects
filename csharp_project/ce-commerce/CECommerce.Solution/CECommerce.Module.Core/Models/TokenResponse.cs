
namespace CECommerce.Module.Core.Models
{
    public class TokenResponse
    {
        public string AccessToken { get; set; }
        public string TokenType { get; set; } = "Bearer";
        public int ExpiresIn { get; set; }
        public string[]? Roles { get; set; }
        public string UId { get; set; }
    }
}
