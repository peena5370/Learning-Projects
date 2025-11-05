using CECommerce.Module.User.Models;
using Microsoft.EntityFrameworkCore;

namespace CECommerce.Module.User.Context
{
    public class UserContext(DbContextOptions<UserContext> options) : DbContext(options)
    {
        public DbSet<UserAccountDAO> UserAccounts { get; set; } = null!;
        public DbSet<UserRoleDAO> UserRoles { get; set; } = null!;
        public DbSet<UserUserRoleDAO> UserUserRoles { get; set; } = null!;
        public DbSet<AdminProfileDAO> AdminProfiles { get; set; } = null!;
        public DbSet<BuyerProfileDAO> BuyerProfiles { get; set; } = null!;
        public DbSet<SellerProfileDAO> SellerProfiles { get; set; } = null!;
        public DbSet<ShippingAddressDAO> ShippingAddresses { get; set; } = null!;
    }
}
