package data.util;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtill {

	private Key key;
	
	public JwtUtill(String secret) {
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	 public String createToken(String user_id, String user_pass, String user_num) {

	        String token = Jwts.builder()
	                .claim("user_id", user_id)
	                .claim("user_pass", user_pass)
	                .claim("user_num", user_num)
	                .signWith(key, SignatureAlgorithm.HS256)
	                .compact();
	        
	        return token;
	    }
}
