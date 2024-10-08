package com.Distributed_E_commerce_Microservice.user_management_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.dynalink.beans.StaticClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;


@Component
public class JwtUtils {

    private static String jwtSecret = "SecretKey";
    //
       public static String  generateToken(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
    //
    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

}
