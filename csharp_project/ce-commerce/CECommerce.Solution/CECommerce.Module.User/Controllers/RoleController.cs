using CECommerce.Module.User.Filters;
using CECommerce.Module.User.Models;
using CECommerce.Module.User.Services;
using CECommerce.Utility.Logging;
using Microsoft.AspNetCore.Mvc;

namespace CECommerce.Module.User.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [UserRoleFilter]
    public class RoleController(ILogHelper log, IUserRoleService userRoleService) : ControllerBase
    {
        private readonly ILogHelper _log = log;
        private readonly IUserRoleService _userRoleService = userRoleService;

        [HttpPost]
        public async Task<IActionResult> CreateRole([FromBody] UserRoleDTO body)
        {
            _log.LogInfo<RoleController>($"CreateRole: body: {body.RoleName}");

            if (body == null || string.IsNullOrEmpty(body.RoleName))
            {
                return BadRequest(new { Message = "Invalid role data." });
            }

            int result = await _userRoleService.CreateRoleAsync(body);

            if (result == 400)
            {
                _log.LogInfo<RoleController>($"CreateRole: Role with name {body.RoleName} already exists.");
                return Conflict(new { Message = "Role already exists." });
            }
            else if (result <= 0)
            {
                _log.LogError<RoleController>("CreateRole: Failed to create role.");
                return StatusCode(500, new { Message = "Failed to create role." });
            }

            _log.LogInfo<RoleController>($"CreateRole: Created role with name {body.RoleName}. Status: {result}");

            return Ok(new { Message = "success", Status = result });
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetRoleById(long id)
        {
            _log.LogInfo<RoleController>($"GetRoleById: id: {id}");

            var result = await _userRoleService.GetRoleByIdAsync(id);
            if(result == null)
            {
                _log.LogInfo<RoleController>($"GetRoleById: Role with id {id} not found.");
                return NotFound(new { Message = "Role not found." });
            }

            return Ok(result);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateRole(long id, [FromBody] UserRoleDTO body)
        {
            _log.LogInfo<RoleController>($"UpdateRole: id: {id}, body: {body.RoleName}");

            int result = await _userRoleService.UpdateRoleAsync(id, 0, body);
            if(result == 404)             {
                _log.LogInfo<RoleController>($"UpdateRole: Role with id {id} not found.");
                return NotFound(new { Message = "Role not found." });
            }
            else if(result == 400)
            {
                _log.LogInfo<RoleController>($"UpdateRole: Role with name {body.RoleName} already exists.");
                return Conflict(new { Message = "Role already exists." });
            }
            else if (result <= 0)
            {
                _log.LogError<RoleController>("UpdateRole: Failed to update role.");
                return StatusCode(500, new { Message = "Failed to update role." });
            }

            _log.LogInfo<RoleController>($"UpdateRole: Updated role with id {id}. Status: {result}");

            return Ok(new { Message = "success" , Status = result });
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRole(long id)
        {
            _log.LogInfo<RoleController>($"DeleteRole: id: {id}");

            int result = await _userRoleService.DeleteRoleAsync(id);
            if(result == 404)
            {
                _log.LogInfo<RoleController>($"DeleteRole: Role with id {id} not found.");
                return NotFound(new { Message = "Role not found." });
            }
            else if(result <= 0)
            {
                _log.LogError<RoleController>("DeleteRole: Failed to delete role.");
                return StatusCode(500, new { Message = "Failed to delete role." });
            }
            // return response
            return Ok(new { Message = "success", Status = result });
        }

        [HttpGet("list")]
        public async Task<IActionResult> ListRoles(string sort, int offset = 0, int limit = 5)
        {
            // check authorization token here
            // log the request
            // use role service to list all roles
            // return response
            return Ok(new { Message = "success", Roles = new List<string> { "Admin", "User", "Guest" } });
        }
    }
}