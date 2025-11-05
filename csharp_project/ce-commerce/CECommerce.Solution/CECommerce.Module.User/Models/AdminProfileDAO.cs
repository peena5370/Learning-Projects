using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.User.Models
{
    [Table("admin_profile")]
    public class AdminProfileDAO
    {
        [Key]
        [Column("admin_id")]
        public required long AdminId { get; set; }
        [Column("user_id")]
        public required long UserId { get; set; }
        [Column("fullname")]
        public required string Fullname { get; set; }
        [Column("date_of_birth")]
        public DateOnly DateOfBirth { get; set; }
        [Column("age")]
        public byte Age { get; set; }
        [Column("nationality")]
        public required string Nationality { get; set; }
        [Column("department")]
        public string? Department { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
