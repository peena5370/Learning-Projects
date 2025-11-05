
using Microsoft.Extensions.Caching.Memory;

namespace CECommerce.Utility.Helpers
{
    public class CacheHelper(IMemoryCache cache): ICacheHelper
    {
        private readonly IMemoryCache _cache = cache;
        public async Task<T> GetOrSetAsync<T>(string key, Func<Task<T>> factory, TimeSpan? expiration = null, TimeSpan? slidingExpiration = null)
        {
            if (_cache.TryGetValue(key, out T cachedValue))
            {
                return cachedValue;
            }

            var value = await factory();

            var cacheEntryOptions = new MemoryCacheEntryOptions();
            if (expiration.HasValue)
            {
                cacheEntryOptions.SetAbsoluteExpiration(expiration.Value);
            }
            if (slidingExpiration.HasValue)
            {
                cacheEntryOptions.SetSlidingExpiration(slidingExpiration.Value);
            }

            _cache.Set(key, value, cacheEntryOptions);

            return value;
        }

        public void Remove(string key)
        {
            _cache.Remove(key);
        }
    }
}
