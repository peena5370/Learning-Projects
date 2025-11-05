
using System.ComponentModel;

namespace CECommerce.Module.User.Constants
{
    public enum MfaAuthProvider
    {
        [Description("email")]
        Email,
        [Description("sms")]
        Sms,
        [Description("totp")]
        TOTP,
        [Description("webauthn")]
        WebAuthn
    }
}
