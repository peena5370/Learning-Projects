using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Product.Models
{

    [Table("product")]
    public class ProductDAO
    {
        [Key]
        [Column("product_id")]
        public required long ProductId { get; set; }

        [Column("product_name")]
        public required string ProductName { get; set; }

        [Column("description")]
        public string? Description { get; set; }

        [Column("price")]
        public required decimal Price { get; set; }

        [Column("sku")]
        public required string Sku { get; set; }

        [Column("quantity")]
        public required int Quantity { get; set; }

        [Column("category_id")]
        public required long CategoryId { get; set; }

        [Column("is_active")]
        public bool IsActive { get; set; }

        [Column("created_at")]
        public DateTime CreatedAt { get; set; }

        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }

        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
