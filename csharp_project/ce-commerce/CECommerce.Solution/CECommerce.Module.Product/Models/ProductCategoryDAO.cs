
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Product.Models
{
    [Table("product_category")]
    public class ProductCategoryDAO
    {
        [Key]
        [Column("category_id")]
        public required long CategoryId { get; set; }
        [Column("category_name")]
        public required string CategoryName { get; set; }
        [Column("is_active")]
        public bool IsActive { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
