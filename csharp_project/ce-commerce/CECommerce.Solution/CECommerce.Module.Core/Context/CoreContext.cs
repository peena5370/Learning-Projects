
using CECommerce.Module.Core.Models;
using Microsoft.EntityFrameworkCore;

namespace CECommerce.Module.Core.Context
{
    public class CoreContext(DbContextOptions<CoreContext> options) : DbContext(options)
    {
        public DbSet<MfaDAO> Mfas { get; set; } = null!;
    }
}
