using CECommerce.Utility.Constants;
using System.Diagnostics;
using System.Security.Cryptography;

namespace CECommerce.Utility.Helpers
{
    /// <summary>
    /// Class <c>PasswordHelper</c> provides methods for generating secret keys, encrypting passwords, and verifying passwords.
    /// </summary>
    public class PasswordHelper
    {
        /// <summary>
        /// Method <c>GenerateSecretKey</c> generates a random secret key of the specified length.
        /// </summary>
        /// <param name="length"></param>
        /// <returns></returns>
        public static byte[] GenerateSecretKey(int length = PasswordEncryptionConstant.KeySize)
        {
            var salt = new byte[length];

            using var rng = RandomNumberGenerator.Create();
            {
                rng.GetBytes(salt);
            }

            Debug.WriteLine("generated secret key: " + Convert.ToBase64String(salt));
            return salt;

        }

        /// <summary>
        /// Method <c>EncryptPassword</c> encrypts the provided password using the specified key.
        /// </summary>
        /// <param name="password"></param>
        /// <param name="key"></param>
        /// <returns></returns>
        /// <exception cref="ArgumentException"></exception>
        public static string EncryptPassword(string password, byte[] key)
        {
            if (string.IsNullOrEmpty(password) || (key == null || key.Length < 0))
            {
                throw new ArgumentException("Password or key cannot be null or empty.");
            }

            using var pbkdf2 = new Rfc2898DeriveBytes(
                password,
                key,
                PasswordEncryptionConstant.Iterations,
                HashAlgorithmName.SHA256);

            byte[] passwordBytes = pbkdf2.GetBytes(PasswordEncryptionConstant.HashSize);

            Debug.WriteLine($"encrypted password: {Convert.ToBase64String(key)}:{Convert.ToBase64String(passwordBytes)}");

            return $"{Convert.ToBase64String(key)}:{Convert.ToBase64String(passwordBytes)}";
        }

        /// <summary>
        /// Method <c>VerifyPassword</c> checks if the provided password matches the hashed password.
        /// </summary>
        /// <param name="password"></param>
        /// <param name="hashedPassword"></param>
        /// <returns></returns>
        /// <exception cref="ArgumentException"></exception>
        public static bool VerifyPassword(string password, string hashedPassword)
        {
            if (string.IsNullOrEmpty(password) || string.IsNullOrEmpty(hashedPassword))
            {
                throw new ArgumentException("Password or hashed password cannot be null or empty.");
            }

            var parts = hashedPassword.Split(':', 2);
            if (parts.Length != 2)
            {
                return false;
            }

            byte[] key = Convert.FromBase64String(parts[0]);
            byte[] passwordBytes = Convert.FromBase64String(parts[1]);

            using var pbkdf2 = new Rfc2898DeriveBytes(
                password,
                key,
                PasswordEncryptionConstant.Iterations,
                HashAlgorithmName.SHA256);

            byte[] hashOfInput = pbkdf2.GetBytes(PasswordEncryptionConstant.HashSize);

            Debug.WriteLine($"verifying password: {Convert.ToBase64String(key)}:{Convert.ToBase64String(hashOfInput)} against {hashedPassword}");
            return CryptographicOperations.FixedTimeEquals(hashOfInput, passwordBytes);
        }
    }
}
