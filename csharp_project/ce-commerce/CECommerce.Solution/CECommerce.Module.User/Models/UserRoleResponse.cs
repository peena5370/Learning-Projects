
namespace CECommerce.Module.User.Models
{
    public class UserRoleResponse
    {
        public required long Id { get; set; }
        public required string RoleName { get; set; }
        public bool IsActive { get; set; }
        public DateTime ModifiedDate { get; set; }
    }
}
