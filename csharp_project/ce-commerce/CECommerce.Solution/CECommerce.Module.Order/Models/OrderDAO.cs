using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Order.Models
{
    [Table("order")]
    public class OrderDAO
    {
        [Key]
        [Column("order_id")]
        public required long OrderId { get; set; }
        [Column("user_id")]
        public required long UserId { get; set; }
        [Column("order_date")]
        public DateTime OrderDate { get; set; }
        [Column("payment_status")]
        public required string PaymentStatus { get; set; }
        [Column("order_status")]
        public required string OrderStatus { get; set; }
        [Column("address_id")]
        public required long AddressId { get; set; }
        [Column("tracking_number")]
        public string? TrackingNumber { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
