using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Payroll.Utilities.Helpers
{
    public class StringHelper
    {

        public static string GenerateNewGuid()
        {
            return Guid.NewGuid().ToString().Replace("-", "").ToUpper();
        }
    }
}
