using Microsoft.AspNetCore.Mvc;
using Payroll.Modules.HR.Context;
using Payroll.Modules.HR.Models;
using System.Diagnostics;

namespace Payroll.Modules.HR.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeeController(EmployeeContext context) : ControllerBase
    {
        private readonly EmployeeContext _context = context;

        [HttpGet]
        public IActionResult GetEmployee()
        {
            Debug.WriteLine("api come in");
            //var employee = _employeeMapper.GetEmployeeAsync();

            Debug.WriteLine("come in here");
            return Ok();
        }

        // POST api/<ValuesController>
        [HttpPost]
        public void Post([FromBody] EmployeeDTO employeeDto)
        {
            Debug.WriteLine("api post come in");
            Debug.WriteLine($"Inputed name: {employeeDto.Name} age: {employeeDto.Age}");

            string id = Guid.NewGuid().ToString();

            Debug.WriteLine($"generated new id: {id}");

            var employee = new Employee
            {
                Id = id,
                Name = employeeDto.Name,
                Age = employeeDto.Age
            };

            _context.Employees.Add(employee);

            int status = _context.SaveChanges();

            Debug.WriteLine($"status returned: {status}");

            foreach (var dbEmployee in context.Employees)
            {
                Debug.WriteLine($"employee result{{ id: {dbEmployee.Id}, name: {dbEmployee.Name}, age: {dbEmployee.Age} }}");
            }

            Debug.WriteLine("$post end");
        }

        // c# request mapping template, refers here
        //// GET: api/<ValuesController>
        //[HttpGet]
        //public IEnumerable<string> Get()
        //{
        //    return new string[] { "value1", "value2" };
        //}

        //// GET api/<ValuesController>/5
        //[HttpGet("{id}")]
        //public string Get(int id)
        //{
        //    return "value";
        //}

        //// POST api/<ValuesController>
        //[HttpPost]
        //public void Post([FromBody] string value)
        //{
        //}

        //// PUT api/<ValuesController>/5
        //[HttpPut("{id}")]
        //public void Put(int id, [FromBody] string value)
        //{
        //}

        //// DELETE api/<ValuesController>/5
        //[HttpDelete("{id}")]
        //public void Delete(int id)
        //{
        //}
    }
}