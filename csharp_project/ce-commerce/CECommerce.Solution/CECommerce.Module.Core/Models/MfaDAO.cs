
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CECommerce.Module.Core.Models
{
    [Table("mfa")]
    public class MfaDAO
    {
        [Key]
        [Column("mfa_id")]
        public required long MfaId { get; set; }
        [Column("user_id")]
        public required long UserId { get; set; }
        [Column("mfa_method")]
        public required string MfaMethod { get; set; }
        [Column("modified_at")]
        public DateTime ModifiedAt { get; set; }
        [Column("modified_by")]
        public long? ModifiedBy { get; set; }
    }
}
