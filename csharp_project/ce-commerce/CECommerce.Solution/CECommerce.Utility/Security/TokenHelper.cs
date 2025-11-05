
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Security.Cryptography;

namespace CECommerce.Utility.Security
{
    public static class TokenHelper
    {
        private static RsaSecurityKey GetPrivateKeyFromStore(string privateKeyPem)
        {
            using RSA rsa = RSA.Create();
            rsa.ImportFromPem(privateKeyPem);
            return new RsaSecurityKey(rsa);
        }

        private static RsaSecurityKey GetPublicKeyFromStore(string publicKeyPem)
        {
            using RSA rsa = RSA.Create();
            rsa.ImportFromPem(publicKeyPem);
            return new RsaSecurityKey(rsa);
        }

        public static string GenerateToken(string subject, IDictionary<string, string> customClaims, string privateKeyPem, int expireMinutes = 15)
        {
            var privateKey = GetPrivateKeyFromStore(privateKeyPem);

            var claims = new List<Claim>
            {
                new Claim(JwtRegisteredClaimNames.Sub, subject),
                new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
                new Claim(JwtRegisteredClaimNames.Iat, DateTimeOffset.UtcNow.ToUnixTimeSeconds().ToString(), ClaimValueTypes.Integer64)
            };

            foreach (var pair in customClaims)
            {
                claims.Add(new Claim(pair.Key, pair.Value));
            }

            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(claims),
                Expires = DateTime.UtcNow.AddMinutes(expireMinutes),
                SigningCredentials = new SigningCredentials(privateKey, SecurityAlgorithms.RsaSha256)
            };

            var tokenHandler = new JwtSecurityTokenHandler();
            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }

        public static ClaimsPrincipal? VerifyToken(string token, string publicKeyPem, out SecurityToken validatedToken)
        {
            var publicKey = GetPublicKeyFromStore(publicKeyPem);

            var tokenValidationParameters = new TokenValidationParameters
            {
                ValidateIssuer = false,
                ValidateAudience = false,
                ValidateLifetime = true,
                ValidateIssuerSigningKey = true,
                IssuerSigningKey = publicKey,
                ClockSkew = TimeSpan.FromSeconds(30)
            };

            var tokenHandler = new JwtSecurityTokenHandler();
            return tokenHandler.ValidateToken(token, tokenValidationParameters, out validatedToken);
        }

        public static bool IsTokenValid(string token, string publicKeyPem)
        {
            try
            {
                VerifyToken(token, publicKeyPem, out var validatedToken);
                return validatedToken.ValidTo > DateTime.UtcNow;
            }
            catch
            {
                return false;
            }
        }

        public static IDictionary<string, string> GetTokenClaims(string token)
        {
            var handler = new JwtSecurityTokenHandler();
            var jwt = handler.ReadJwtToken(token);
            return jwt.Claims.ToDictionary(c => c.Type, c => c.Value);
        }
    }
}
