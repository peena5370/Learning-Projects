using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.User.Models
{
    [Table("seller_profile")]
    public class SellerProfileDAO
    {
        [Key]
        [Column("seller_id")]
        public required long SellerId { get; set; }
        [Column("user_id")]
        public required long UserId { get; set; }
        [Column("business_name")]
        public required string BusinessName { get; set; }
        [Column("date_of_birth")]
        public DateOnly DateOfBirth { get; set; }
        [Column("age")]
        public byte Age { get; set; }
        [Column("nationality")]
        public required string Nationality { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
