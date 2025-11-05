using System.ComponentModel;

namespace CECommerce.Module.User.Constants
{
    public enum AuthProvider
    {
        [Description("internal")]
        Internal,
        [Description("okta")]
        Okta
    }
}
