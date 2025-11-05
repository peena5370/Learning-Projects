using Microsoft.Extensions.Logging;

namespace CECommerce.Utility.Logging
{
    public class LogHelper(ILoggerFactory loggerFactory) : ILogHelper
    {
        private readonly ILoggerFactory _loggerFactory = loggerFactory;

        public void LogInfo<T>(string message, params object?[] args)
        {
            var logger = _loggerFactory.CreateLogger<T>();

            if (args == null || args.Length == 0)
            {
                logger.LogInformation(message);
            }
            else
            {
                logger.LogInformation(message, args);
            }
        }

        public void LogWarning<T>(string message, Exception? ex = null)
        {
            var logger = _loggerFactory.CreateLogger<T>();

            if (ex != null)
            {
                logger.LogWarning(ex, message);
                return;
            }
            else 
            { 
                logger.LogWarning(message); 
            }
        }

        public void LogError<T>(string message, Exception? ex = null)
        {
            var logger = _loggerFactory.CreateLogger<T>();
            logger.LogError(ex, message);
        }

        public void LogDebug<T>(string message, params object?[] args)
        {
            var logger = _loggerFactory.CreateLogger<T>();
            if (args == null || args.Length == 0)
            {
                logger.LogDebug(message);
            }
            else
            {
                logger.LogDebug(message, args);
            }
        }
    }
}
