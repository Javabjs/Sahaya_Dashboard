package com.sahayadashboard.security.jwtUtils;



import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sahayadashboard.security.service.UserDetailsImpl;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
@Component

public class JwtHelper {
	private static final Logger logger = LoggerFactory.getLogger(JwtHelper.class);
	public static final long JWT_TOKEN_VALIDITY= 5 * 60 * 60;

	 public static final String SECRET = "SahayaDashboardMadeByBJSkfhskhdkahkdhaklhdakldhaklhdlkah";

	public static String getClaimFromToken(String token, String claimKey) {
		return extractClaims(token).get(claimKey, String.class);
	}

	public static String getUuidFromToken(String token) {
		return getClaimFromToken(token, "uuid");
	}

	public static String getEmailFromToken(String token) {
		return getClaimFromToken(token, "email");
	}

	public static String  generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		Map<String, Object> claims = new HashMap<>();
		claims.put("uuid", userPrincipal.getId());
		claims.put("email", userPrincipal.getEmail());

		return Jwts.builder()
				.setClaims(claims)
				.setSubject("API Consumer")
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime()  + 86400000))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public static List<String> getRolesFromToken(String token) {
		Claims claims = extractClaims(token);
		return claims.get("roles", List.class);
	}
	
	
	    private static Claims extractClaims(String token) {
	        return Jwts
	                .parserBuilder()
	                .setSigningKey(getSigningKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    private static Key getSigningKey() {
	        final byte[] keyBytes = Decoders.BASE64.decode(SECRET);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }



	public static  boolean validateJwtToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parse(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

}

	





