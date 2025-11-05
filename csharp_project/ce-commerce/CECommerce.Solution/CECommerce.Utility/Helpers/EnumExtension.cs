using System.ComponentModel;

namespace CECommerce.Utility.Helpers
{
    public static class EnumExtension
    {
        public static string GetDescription(this Enum value)
        {
            var field = value.GetType().GetField(value.ToString());
            if (field != null)
            {
                object[] attributes = field.GetCustomAttributes(typeof(DescriptionAttribute), false);
                if ((attributes != null) && (attributes.Length > 0))
                {
                    return ((DescriptionAttribute)attributes[0]).Description;
                }
            }

            return value.ToString();
        }
    }
}
