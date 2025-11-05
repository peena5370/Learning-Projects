using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.User.Models
{
    [Table("user_user_role")]
    public class UserUserRoleDAO
    {
        [Key]
        [Column("user_role_id")]
        public required long UserRoleId { get; set; }

        [Column("user_id")]
        public required long UserId { get; set; }

        [Column("role_id")]
        public required long RoleId { get; set; }
    }
}
