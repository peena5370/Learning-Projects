using Microsoft.EntityFrameworkCore;
using CECommerce.Module.Product.Models;

namespace CECommerce.Module.Product.Context
{
    public class ProductContext(DbContextOptions<ProductContext> options) : DbContext(options)
    {
        public DbSet<ProductDAO> Products { get; set; } = null!;
        public DbSet<ProductImageDAO> ProductImages { get; set; } = null!;
        public DbSet<ProductCategoryDAO> ProductCategories { get; set; } = null!;
    }
}
