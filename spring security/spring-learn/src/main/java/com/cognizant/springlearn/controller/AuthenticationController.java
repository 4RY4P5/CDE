package com.cognizant.springlearn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	private Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start authentication controller...authenticate");
		String user = getUser(authHeader);
		LOGGER.debug(user);
		Map<String, String> map = new HashMap<String, String>();
		String token = generateJwt(user);
		LOGGER.debug(token);
		map.put("token", token);
		LOGGER.info("End authentication controller...");
		return map;
	}

	private String getUser(String authHeader) {
		LOGGER.info("Getting User..");
		String encodedCredentials = authHeader.substring(6);
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		int index =decoded.indexOf(":");		
		String user = decoded.substring(0, index);
		LOGGER.debug(user);
		return user;
		
	}
	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;
	}
	
}
