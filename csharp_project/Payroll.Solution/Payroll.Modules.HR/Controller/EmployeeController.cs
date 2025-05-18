using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Payroll.Modules.HR.Context;
using Payroll.Modules.HR.Models;
using Payroll.Modules.HR.Services;
using System.Diagnostics;

namespace Payroll.Modules.HR.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeeController(IEmployeeService employeeService, ILogger<EmployeeController> log) : ControllerBase
    {
        private readonly ILogger<EmployeeController> _log = log;
        private readonly IEmployeeService _employeeService = employeeService;

        [HttpGet]
        public async Task<ActionResult<IEnumerable<Employee>>> GetAllEmployees()
        {
            _log.LogInformation("GetAllEmployees() start");

            long currentMillis = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            var employees = await _employeeService.GetAllEmployeesAsync();

            long endMillis = DateTimeOffset.Now.ToUnixTimeMilliseconds() - currentMillis;

            _log.LogInformation("GetAllEmployees() end. Time taken: {Time}", endMillis);
            return Ok(employees);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Employee>> GetEmployeeById(string id)
        {
            _log.LogInformation("GetEmployeeById() start");

            long currentMillis = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            var employee = await _employeeService.GetEmployeesByIdAsync(id);

            if (employee == null)
            {
                return NotFound(new { message = "Employee data not found.", id });
            }
            else
            {
                long endMillis = DateTimeOffset.Now.ToUnixTimeMilliseconds() - currentMillis;

                _log.LogInformation("GetEmployeeById() end. Time taken: {Time}", endMillis);
                return Ok(employee);
            }

        }

        // POST api/<ValuesController>
        [HttpPost]
        public ActionResult<string> CreateEmployee([FromBody] EmployeeDTO employeeDTO)
        {
            _log.LogInformation("Inputed name: {string} age: {int}", employeeDTO.Name, employeeDTO.Age);

            int status = _employeeService.CreateEmployee(employeeDTO);

            if (status == 0)
            {
                return BadRequest(new { message = "Employee data created fail" });
            }
            else
            {
                return Ok(new { message = "Create success" });
            }
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateEmployee(string id, [FromBody] EmployeeDTO employeeDTO)
        {
            var status = await _employeeService.UpdateEmployeeAsync(id, employeeDTO);

            if (status == 0)
            {
                return NotFound(new { message = "Employee not found" });
            }
            else
            {
                return Ok(new { message = "Update success " });
            }
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteEmployee(string id)
        {
            var status = await _employeeService.DeleteEmployeeAsync(id);

            if (status == 0)
            {
                return NotFound(new { message = "Employee not found" });
            }
            else
            {
                return Ok(new { message = "Delete success " });
            }
        }
    }
}