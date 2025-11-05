
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Cart.Models
{
    [Table("cart_item")]
    public class CartItemDAO
    {
        [Key]
        [Column("item_id")]
        public required long ItemId { get; set; }
        [Column("cart_id")]
        public required long CartId { get; set; }
        [Column("product_id")]
        public required long ProductId { get; set; }
        [Column("quantity")]
        public required int Quantity { get; set; }
    }
}
