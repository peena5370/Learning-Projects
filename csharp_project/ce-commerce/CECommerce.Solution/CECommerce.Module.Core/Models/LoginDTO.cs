using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CECommerce.Module.User.Models
{
    public record LoginDTO(string Username, string Password, bool RememberMe);
}
