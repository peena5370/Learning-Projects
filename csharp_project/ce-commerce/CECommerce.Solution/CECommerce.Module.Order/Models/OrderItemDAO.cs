using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Order.Models
{
    [Table("order_item")]
    public class OrderItemDAO
    {
        [Key]
        [Column("order_item_id")]
        public required long OrderItemId { get; set; }
        [Column("order_id")]
        public required long OrderId { get; set; }
        [Column("product_id")]
        public required long ProductId { get; set; }
        [Column("quantity")]
        public required int Quantity { get; set; }
        [Column("unit_price")]
        public required decimal UnitPrice { get; set; }
        [Column("sub_total")]
        public required decimal SubTotal { get; set; }
    }
}
