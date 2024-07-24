//package com.sahayadashboard.security;
//
//
//
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//
//
//@Service
//@Component
//
//public class JwtHelper {
//	
//	public static final long JWT_TOKEN_VALIDITY= 5 * 60 * 60;
//	
//	 public static final String SECRET = "asasrfrftgdewqooopmkmckmAA3F4528482B4D6251655468576D5A347437&quot";
//
//	 public static String extractUsername(String token) {
//	        return extractClaim(token, Claims::getSubject);
//	    }
//
//	    public static String generateToken(
//	            Map<String, Object> extractClaim,
//	            UserDetails userDetails)
//	    {
//	        return Jwts
//	                .builder()
//	                .setClaims(extractClaim)
//	                .setSubject(userDetails.getUsername())
//	                .setIssuedAt(new Date(System.currentTimeMillis()))
//	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
//	                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//	                .compact();
//	    }
//
//	    public static String generateToken(UserDetails userDetails) {
//	        return generateToken(new HashMap<>(), userDetails);
//	    }
//
//	    public static boolean isTokenValid(
//	            String token,
//	            UserDetails userDetails)
//	    {
//	     final var username = extractUsername(token);
//	        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//	    }
//
//	    private static boolean isTokenExpired(String token) {
//	        return extractExpiration(token).before(new Date());
//	    }
//
//	    private static Date extractExpiration(String token) {
//	        return extractClaim(token, Claims::getExpiration);
//	    }
//
//	    private static Claims extractClaims(String token) {
//	        return Jwts
//	                .parserBuilder()
//	                .setSigningKey(getSigningKey())
//	                .build()
//	                .parseClaimsJws(token)
//	                .getBody();
//	    }
//
//	    private static Key getSigningKey() {
//	        final byte[] keyBytes = Decoders.BASE64.decode(SECRET);
//	        return Keys.hmacShaKeyFor(keyBytes);
//	    }
//
//	    private static <C> C extractClaim(
//	            String token,
//	            Function<Claims, C> claimsResolver)
//	     {
//	        final var claims = extractClaims(token);
//	        return claimsResolver.apply(claims);
//	    }
//
//		public boolean validateToken(String token, UserDetails userDetails) {
//			final String username = extractUsername(token);
//	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	    
//		}
//
//	}
//	 
//
//	
//	
//
