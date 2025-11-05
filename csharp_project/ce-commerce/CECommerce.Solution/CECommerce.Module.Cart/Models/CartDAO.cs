
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Cart.Models
{
    [Table("cart")]
    public class CartDAO
    {
        [Key]
        [Column("cart_id")]
        public required long CartId { get; set; }
        [Column("user_id")]
        public required long UserId { get; set; }
        [Column("created_at")]
        public DateTime CreatedAt { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
