
using System.ComponentModel;

namespace CECommerce.Module.Order.Constants
{
    public enum PaymentMethodRefType
    {
        [Description("Credit and Debit Card")]
        CreditCard,
        [Description("E-Wallet")]
        EWallet,
        [Description("Online Banking")]
        OnlineBanking,
        [Description("COD")]
        CashOnDelivery,
        [Description("Other")]
        Other
    }
}
