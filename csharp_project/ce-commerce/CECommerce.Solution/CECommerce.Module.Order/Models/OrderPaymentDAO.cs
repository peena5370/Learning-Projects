using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Order.Models
{
    [Table("order_payment")]
    public class OrderPaymentDAO
    {
        [Key]
        [Column("payment_id")]
        public required long PaymentId { get; set; }
        [Column("order_id")]
        public required long OrderId { get; set; }
        [Column("payment_method")]
        public required string PaymentMethod { get; set; }
        [Column("payment_date")]
        public DateTime PaymentDate { get; set; }
        [Column("payment_amount")]
        public required decimal PaymentAmount { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
