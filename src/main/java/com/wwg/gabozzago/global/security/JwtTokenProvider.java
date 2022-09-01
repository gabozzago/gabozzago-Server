package com.wwg.gabozzago.global.security;

import com.wwg.gabozzago.global.error.ErrorCode;
import com.wwg.gabozzago.global.error.exception.ExpiredTokenException;
import com.wwg.gabozzago.global.error.exception.InvalidTokenException;
import com.wwg.gabozzago.global.security.auth.AuthDetailsService;
import com.wwg.gabozzago.global.security.properties.JwtProperties;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    public String generateAccessToken(String email){
        return generateToken(email,"access",jwtProperties.getAccessSecret(),60*15);
    }
    public String generateRefreshToken(String email){
        return generateToken(email,"refresh",jwtProperties.getRefreshSecret(),60*60*24*7);
    }
    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token, jwtProperties.getAccessSecret()));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }
    public String resolveToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer ")){
            return token.replace("Bearer ","");
        }
        return null;
    }
    private Claims getTokenBody(String token,String secret){
        try{
            return Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
        }catch(ExpiredJwtException e){
            throw new ExpiredTokenException(ErrorCode.EXPIRED_TOKEN_EXCEPTION);
        }catch(MalformedJwtException | SignatureException e){
            throw new InvalidTokenException(ErrorCode.INVALID_TOKEN_EXCEPTION);
        }
    }
    private String getTokenSubject(String token,String secret){
        return getTokenBody(token,secret).getSubject();
    }
    private String generateToken(String email,String type,String secret,Integer exp){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secret.getBytes()))
                .claim("type",type)
                .setIssuedAt(new Date())
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis()+exp*1000))
                .compact();
    }
    public String extractEmailFromRefreshToken(String token){
        String refresh = token.replace("Bearer","");
        return getTokenSubject(refresh, jwtProperties.getRefreshSecret());
    }
}
