using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Logging;
using Payroll.Modules.HR.Context;
using Payroll.Modules.HR.Models;
using Payroll.Utilities.Helpers;

namespace Payroll.Modules.HR.Services
{
    public class EmployeeService(EmployeeContext context, ILogger<EmployeeService> log, IMemoryCache cache) : IEmployeeService
    {
        private readonly ILogger<EmployeeService> _log = log;
        private readonly EmployeeContext _context = context;
        private readonly IMemoryCache _cache = cache;

        public async Task<IEnumerable<Employee>> GetAllEmployeesAsync()
        {
            var employees = await _context.Employees.ToListAsync();

            _log.LogInformation("GetAllEmployees success, size: {int}", employees.Count);

            return employees;
        }

        public async Task<Employee> GetEmployeesByIdAsync(string id)
        {

            if (_cache.TryGetValue(id, out Employee cacheEmployee))
            {
                _log.LogInformation("GetEmployeeById cache success, id: {string}", cacheEmployee?.Id);

                return cacheEmployee;
            }

            var employeee = await _context.Employees.FindAsync(id);

            _log.LogInformation("GetEmployeeById success, id: {string}", employeee?.Id);

            var cacheEntryOptions = new MemoryCacheEntryOptions()
                .SetSlidingExpiration(TimeSpan.FromMinutes(5)) // reset time if accessed
                .SetAbsoluteExpiration(TimeSpan.FromMinutes(2)) // max lifespan
                .SetPriority(CacheItemPriority.Normal);

            _cache.Set(id, employeee, cacheEntryOptions);

            return employeee;
        }

        public int CreateEmployee(EmployeeDTO employeeDTO)
        {
            int status = 0;

            string id = StringHelper.GenerateNewGuid();

            var employee = new Employee
            {
                Id = id,
                Name = employeeDTO.Name,
                Age = employeeDTO.Age
            };

            _context.Employees.Add(employee);

            status = _context.SaveChanges();

            _log.LogInformation("CreateEmployee id: {string}, status: {int}", id, status);

            return status;
        }

        public async Task<int> UpdateEmployeeAsync(string id, EmployeeDTO employeeDTO)
        {
            var status = 0;

            var employee = await _context.Employees.FindAsync(id);

            if (employee == null)
            {
                status = 0;
            }
            else
            {
                employee.Name = employeeDTO.Name;
                employee.Age = employeeDTO.Age;

                _context.Employees.Update(employee);

                status = await _context.SaveChangesAsync();

                _cache.Remove(id);
            }

            _log.LogInformation("Update id: {string}, status: {int}", id, status);

            return status;
        }

        public async Task<int> DeleteEmployeeAsync(string id)
        {
            var status = 0;

            var employee = await _context.Employees.FindAsync(id);

            if (employee == null)
            {
                status = 0;
            }
            else
            {
                _context.Employees.Remove(employee);

                status = await _context.SaveChangesAsync();

                _cache.Remove(id);
            }

            _log.LogInformation("Delete id: {string}, status: {int}", id, status);

            return status;
        }
    }
}
