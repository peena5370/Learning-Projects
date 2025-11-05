
namespace CECommerce.Utility.Logging
{
    public interface ILogHelper
    {
        void LogInfo<T>(string message, params object?[] args);
        void LogWarning<T>(string message, Exception? ex = null);
        void LogError<T>(string message, Exception? ex = null);
        void LogDebug<T>(string message, params object?[] args);
    }
}
