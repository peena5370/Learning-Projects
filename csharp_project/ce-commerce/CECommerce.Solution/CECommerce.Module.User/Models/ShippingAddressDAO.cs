
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.User.Models
{
    [Table("shipping_address")]
    public class ShippingAddressDAO
    {
        [Key]
        [Column("address_id")]
        public required long AddressId { get; set; }
        [Column("user_id")]
        public required long UserId { get; set; }
        [Column("type")]
        public required string Type { get; set; } // e.g., "home", "work"
        [Column("country")]
        public string? Country { get; set; }
        [Column("city")]
        public string? City { get; set; }
        [Column("postal_code")]
        public int PostalCode { get; set; }
        [Column("address_1")]
        public string? Address1 { get; set; }
        [Column("address_2")]
        public string? Address2 { get; set; }
        [Column("is_default")]
        public bool IsDefault { get; set; }
        [Column("address_type")]
        public required string AddressType { get; set; } // e.g., "shipping", "billing"
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }

    }
}
