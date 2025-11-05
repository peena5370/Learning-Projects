package com.company.payroll.security.util

import com.company.payroll.security.prop.JwtTokenProperty
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*
import javax.crypto.spec.SecretKeySpec


@Component
class JwtTokenUtil(@Autowired private val jwtTokenProperty: JwtTokenProperty)
{

    private val ALG = SignatureAlgorithm.HS256
    private val issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS)

    /**
     * Generate token
     * @param Claims
     * @return Token
     */
    fun generateToken(username: String, claims: Map<String, Any>): String
    {
        val key: Key = SecretKeySpec(Base64.getEncoder().encode(jwtTokenProperty.key.toByteArray()), ALG.jcaName)
        val expiration = issuedAt.plus(jwtTokenProperty.ttl.toLong(), ChronoUnit.SECONDS)
        return Jwts.builder().setClaims(claims).setSubject(username).setExpiration(Date.from(expiration))
            .signWith(key, ALG).compact()
    }

    /**
     * Get claims from token
     * @param token
     * @return Claims
     */
    fun getClaims(token: String): Claims
    {
        return Jwts.parserBuilder().setSigningKey(Base64.getEncoder().encode(jwtTokenProperty.key.toByteArray()))
            .build().parseClaimsJws(token).body
    }

    /**
     * Get subject username
     * @param token
     * @return
     */
    fun getUsername(token: String): String?
    {
        val claims = getClaims(token)
        return claims.subject
    }

    /**
     * validate token
     * @param token
     * @return
     */
    fun validateToken(token: String): Boolean
    {
        return getUsername(token) != null && isExpired(token)
    }

    /**
     * Validate token is expired
     * @param token
     * @return
     */
    fun isExpired(token: String): Boolean
    {
        val claims = getClaims(token)
        return claims.expiration.after(Date.from(Instant.now().truncatedTo(ChronoUnit.SECONDS)))
    }
}