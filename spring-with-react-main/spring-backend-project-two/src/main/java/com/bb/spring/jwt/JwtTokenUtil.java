package com.bb.spring.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bb.spring.beans.UserList;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);
	// 24 hours
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
	
	@Value("${app.jwt.secret}")
	private String secretKey;
	
	public String generateAccessToken(UserList user) {
		return Jwts.builder().setSubject(user.getId()+","+user.getEmail())
				.setIssuer("BizarreBazaar").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
	}
	
	public boolean validateAccessToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		}catch(ExpiredJwtException ex) {
			logger.error("expired", ex);
		}catch(IllegalArgumentException ex) {
			logger.error("nothing there", ex);
		}catch(MalformedJwtException ex) {
			logger.error("invalid", ex);
		}catch(UnsupportedJwtException ex) {
			logger.error("not supported", ex);
		}catch(SignatureException ex) {
			logger.error("signature error", ex);
		}
		return false;
	}
	
	public String getSubject(String token) {
		return parseClaims(token).getSubject();
	}
	private Claims parseClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
	}

}
