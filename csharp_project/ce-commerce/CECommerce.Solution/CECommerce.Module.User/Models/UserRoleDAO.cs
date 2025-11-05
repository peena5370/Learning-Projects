using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.User.Models
{
    [Table("user_role")]
    public class UserRoleDAO
    {
        [Key]
        [Column("role_id")]
        public required long RoleId { get; set; }

        [Column("role_name")]
        public required string RoleName { get; set; }

        [Column("is_active")]
        public bool IsActive { get; set; }

        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }

        [Column("modified_by")]
        public long? ModifiedBy { get; set; }

    }
}
