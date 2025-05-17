using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Payroll.Modules.HR.Models;

namespace Payroll.Modules.HR.Context
{
    public class EmployeeContext(DbContextOptions<EmployeeContext> options) : DbContext(options)
    {
        public DbSet<Employee> Employees { get; set; }
    }
}
