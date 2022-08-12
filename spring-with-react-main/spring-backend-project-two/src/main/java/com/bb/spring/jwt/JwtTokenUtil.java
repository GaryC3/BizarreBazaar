package com.bb.spring.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bb.spring.beans.UserList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
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
	

}
