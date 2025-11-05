using CECommerce.Module.Order.Models;
using Microsoft.EntityFrameworkCore;

namespace CECommerce.Module.Order.Context
{
    public class OrderContext(DbContextOptions<OrderContext> options) : DbContext(options)
    {
        public DbSet<OrderDAO> Products { get; set; } = null!;
        public DbSet<OrderPaymentDAO> OrderPayments { get; set; } = null!;
        public DbSet<OrderItemDAO> OrderItems { get; set; } = null!;
    }
}
