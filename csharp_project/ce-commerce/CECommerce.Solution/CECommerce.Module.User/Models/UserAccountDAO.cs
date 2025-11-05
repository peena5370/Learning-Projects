using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.User.Models
{
    [Table("user_account")]
    public class UserAccountDAO
    {
        [Key]
        [Column("user_id")]
        public required long UserId { get; set; }

        [Column("username")]
        public string? Username { get; set; }

        [Column("password_hash")]
        public string? PasswordHash { get; set; }

        [Column("email")]
        public string? Email { get; set; }

        [Column("phone_number")]
        public string? PhoneNumber { get; set; }

        [Column("two_fa_enabled")]
        public bool TwoFaEnabled { get; set; }

        [Column("auth_provider")]
        public required string AuthProvider { get; set; }

        [Column("is_locked")]
        public bool IsLocked { get; set; }

        [Column("status")]
        public required string Status { get; set; }

        [Column("last_login_at")]
        public DateTime? LastLoginAt { get; set; }

        [Column("created_at")]
        public DateTime CreatedAt { get; set; }

        [Column("deleted_at")]
        public DateTime? DeletedAt { get; set; }

        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }

        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
