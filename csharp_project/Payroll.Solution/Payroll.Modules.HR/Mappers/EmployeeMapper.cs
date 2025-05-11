

namespace Payroll.Modules.HR.Mappers;

using System.Data;
using Dapper;
using Payroll.Modules.HR.Models;

public class EmployeeMapper
{

    private readonly IDbConnection _db;

    public EmployeeMapper(IDbConnection db)
    {
        this._db = db;
    }

    public async Task<IEnumerable<Employee>> GetEmployeeAsync() 
    {
        var sql = "SELECT * FROM Employee";

        return await _db.QueryAsync<Employee>(sql);
    }
}


