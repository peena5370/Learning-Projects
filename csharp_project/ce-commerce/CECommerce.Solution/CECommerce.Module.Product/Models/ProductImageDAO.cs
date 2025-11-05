using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Product.Models
{
    [Table("product_image")]
    public class ProductImageDAO
    {
        [Key]
        [Column("image_id")]
        public required long ImageId { get; set; }
        [Column("product_id")]
        public required long ProductId { get; set; }
        [Column("image_path")]
        public required string ImagePath { get; set; }
        [Column("image_type")]
        public required string ImageType { get; set; }
        [Column("image_size")]
        public int ImageSize { get; set; }
        [Column("uploaded_date")]
        public DateTime UploadedDate { get; set; }
    }
}
