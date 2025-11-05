
using CECommerce.Module.Cart.Models;
using Microsoft.EntityFrameworkCore;

namespace CECommerce.Module.Cart.Context
{
    public class CartContext(DbContextOptions<CartContext> options) : DbContext(options)
    {
        public DbSet<CartDAO> Carts { get; set; } = null!;
        public DbSet<CartItemDAO> CartItems { get; set; } = null!;
    }
}
