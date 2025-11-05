using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.User.Models
{
    [Table("buyer_profile")]
    public class BuyerProfileDAO
    {
        [Key]
        [Column("buyer_id")]
        public required long BuyerId { get; set; }
        [Column("user_id")]
        public required long UserId { get; set; }
        [Column("fullname")]
        public required string Fullname { get; set; }
        [Column("display_name")]
        public string? DisplayName { get; set; }
        [Column("date_of_birth")]
        public DateOnly DateOfBirth { get; set; }
        [Column("age")]
        public byte Age { get; set; }
        [Column("nationality_code")]
        public required string NationalityCode { get; set; }
        [Column("bio_data")]
        public string? BioData { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
