

namespace CECommerce.Utility.Helpers
{
    public class SnowflakeIdGenerator
    {
        // Epoch: A custom epoch for Snowflake IDs (e.g., May 29, 2025, 00:00:00 GMT+08)
        // This reduces the size of the timestamp, allowing for more bits for other components.
        // It's important to pick an epoch that is *before* you start generating IDs.
        private const long StartTimestamp = 1748448000000L; // Example: May 29, 2025, 00:00:00 GMT+08 in milliseconds

        // Bit lengths for each component
        private const int DataCenterIdBits = 5;  // 5 bits for data center ID (0-31)
        private const int WorkerIdBits = 5;      // 5 bits for worker ID (0-31)
        private const int SequenceBits = 12;     // 12 bits for sequence number (0-4095)

        // Maximum values for each component
        private const long MaxDataCenterId = -1L ^ (-1L << DataCenterIdBits); // 31
        private const long MaxWorkerId = -1L ^ (-1L << WorkerIdBits);         // 31
        private const long SequenceMask = -1L ^ (-1L << SequenceBits);        // 4095

        // Shift amounts for combining components into a single long
        private const int WorkerIdShift = SequenceBits;                               // 12
        private const int DataCenterIdShift = SequenceBits + WorkerIdBits;            // 12 + 5 = 17
        private const int TimestampLeftShift = SequenceBits + WorkerIdBits + DataCenterIdBits; // 12 + 5 + 5 = 22

        private long _sequence = 0L;
        private long _lastTimestamp = -1L;
        private readonly Lock _lock = new();

        public long DataCenterId { get; private set; }
        public long WorkerId { get; private set; }

        /// <summary>
        /// Initializes a new instance of the SnowflakeIdGenerator.
        /// </summary>
        /// <param name="dataCenterId">The unique ID of the data center (0-31).</param>
        /// <param name="workerId">The unique ID of the worker within the data center (0-31).</param>
        /// <exception cref="ArgumentException">Thrown if dataCenterId or workerId are out of range.</exception>
        public SnowflakeIdGenerator(long dataCenterId, long workerId)
        {
            if (dataCenterId > MaxDataCenterId || dataCenterId < 0)
            {
                throw new ArgumentOutOfRangeException(nameof(dataCenterId), $"Data center ID must be between 0 and {MaxDataCenterId}");
            }

            if (workerId > MaxWorkerId || workerId < 0)
            {
                throw new ArgumentOutOfRangeException(nameof(workerId), $"Worker ID must be between 0 and {MaxWorkerId}");
            }

            DataCenterId = dataCenterId;
            WorkerId = workerId;
        }

        /// <summary>
        /// Generates a new unique Snowflake ID.
        /// This method is thread-safe.
        /// </summary>
        /// <returns>A unique 64-bit long ID.</returns>
        /// <exception cref="Exception">Thrown if the system clock moves backwards significantly.</exception>
        public long NextId()
        {
            lock (_lock)
            {
                long timestamp = GetCurrentTimestampMilliseconds();

                if (timestamp < _lastTimestamp)
                {
                    // Clock moved backwards. This is a critical error in distributed systems.
                    // You might want to log this or have a more sophisticated recovery mechanism.
                    throw new Exception($"Clock moved backwards. Refusing to generate ID for {_lastTimestamp - timestamp} milliseconds.");
                }

                if (_lastTimestamp == timestamp)
                {
                    // Same millisecond, increment sequence
                    _sequence = (_sequence + 1) & SequenceMask;
                    if (_sequence == 0)
                    {
                        // Sequence overflow, wait for next millisecond
                        timestamp = TillNextMillis(_lastTimestamp);
                    }
                }
                else
                {
                    // New millisecond, reset sequence
                    _sequence = 0L;
                }

                _lastTimestamp = timestamp;

                // Combine all parts into the final ID
                return ((timestamp - StartTimestamp) << TimestampLeftShift) |
                       (DataCenterId << DataCenterIdShift) |
                       (WorkerId << WorkerIdShift) |
                       _sequence;
            }
        }

        /// <summary>
        /// Waits until the next millisecond.
        /// </summary>
        private long TillNextMillis(long lastTimestamp)
        {
            long timestamp = GetCurrentTimestampMilliseconds();
            while (timestamp <= lastTimestamp)
            {
                timestamp = GetCurrentTimestampMilliseconds();
                // Small delay to avoid busy-waiting too aggressively, though usually not needed
                // if clock ticks reliably.
                Thread.Sleep(1);
            }
            return timestamp;
        }

        /// <summary>
        /// Gets the current timestamp in milliseconds since the Unix epoch.
        /// </summary>
        private long GetCurrentTimestampMilliseconds()
        {
            return DateTimeOffset.UtcNow.ToUnixTimeMilliseconds();
        }
    }
}
