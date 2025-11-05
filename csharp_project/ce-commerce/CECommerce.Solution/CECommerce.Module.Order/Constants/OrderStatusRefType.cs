
using System.ComponentModel;

namespace CECommerce.Module.Order.Constants
{
    public enum OrderStatusRefType
    {
        [Description("Open")]
        Pending,
        [Description("Processing")]
        Processing,
        [Description("Shipped")]
        Shipped,
        [Description("Delivered")]
        Delivered,
        [Description("Cancelled")]
        Cancelled
    }
}
