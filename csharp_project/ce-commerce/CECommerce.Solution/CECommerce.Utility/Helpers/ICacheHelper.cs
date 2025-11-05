
namespace CECommerce.Utility.Helpers
{
    public interface ICacheHelper
    {
        Task<T> GetOrSetAsync<T>(string key, Func<Task<T>> factory, TimeSpan? expiration = null, TimeSpan? slidingExpiration = null);
        void Remove(string key);
    }
}
