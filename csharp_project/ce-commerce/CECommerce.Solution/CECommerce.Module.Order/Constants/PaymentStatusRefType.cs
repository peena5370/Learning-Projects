
using System.ComponentModel;

namespace CECommerce.Module.Order.Constants
{
    public enum PaymentStatusRefType
    {
        [Description("Pending")]
        Pending,
        [Description("Completed")]
        Completed,
        [Description("Failed")]
        Failed,
        [Description("Refunded")]
        Refunded,
        [Description("Cancelled")]
        Cancelled,
        [Description("Partially Refunded")]
        PartiallyRefunded,
        [Description("Partially Completed")]    
        PartiallyCompleted
    }
}
