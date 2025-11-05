using CECommerce.Utility.Configurations;
using CECommerce.Utility.Helpers;
using Microsoft.Extensions.Options;

namespace CECommerce.Module.User.Services
{
    public class UserService(/*ILogger<UserService> log,*/ IOptions<SnowflakeSettings> settings) : IUserService
    {
        //private readonly ILogger<UserService> _log = log;
        private readonly SnowflakeSettings _settings = settings.Value;
        public string TestMethod()
        {
            //var test = new TestClass { Id = 1, Value = AuthProvider.Internal.GetDescription() };
            //_log.LogInformation("the test value is: {0}", test.Value);

            SnowflakeIdGenerator generator = new SnowflakeIdGenerator(_settings.DataCenterId, _settings.WorkerId);

            //for (int i = 0; i < 10; i++)
            //{
            //    long id = generator.NextId();
            //    _log.LogInformation("Generated ID: {0}", id);
            //}

            return "Hello from UserService!";
        }
    }
}
