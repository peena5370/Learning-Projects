using Payroll.Modules.HR.Models;

namespace Payroll.Modules.HR.Services
{
    public interface IEmployeeService
    {
        Task<IEnumerable<Employee>> GetAllEmployeesAsync();
        Task<Employee> GetEmployeesByIdAsync(string id);
        int CreateEmployee(EmployeeDTO employeeDTO);

        Task<int> UpdateEmployeeAsync(string id, EmployeeDTO employeeDTO);

        Task<int> DeleteEmployeeAsync(string id);
    }
}
