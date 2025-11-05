using System.ComponentModel;

namespace CECommerce.Module.User.Constants
{
    public enum AccountStatus
    {
        [Description("active")]
        Active,
        [Description("inactive")]
        Inactive,
        [Description("locked")]
        Locked,
        [Description("deleted")]
        Deleted,
        [Description("suspended")]
        Suspended
    }
}
