using System.ComponentModel.DataAnnotations.Schema;

namespace Payroll.Modules.HR.Models
{
    [Table("employee")]
    public class Employee
    {
        [Column("id")]
        public required string Id
        {
            get; set;
        }
        [Column("name")]
        public string Name
        {
            get; set;
        } = string.Empty;
        [Column("age")]
        public int Age
        {
            get; set;
        }
    }
}