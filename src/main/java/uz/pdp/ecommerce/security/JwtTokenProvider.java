package uz.pdp.ecommerce.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import uz.pdp.ecommerce.entity.Role;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    final Environment environment;

    @Autowired
    public JwtTokenProvider(Environment environment) {
        this.environment = environment;
    }
//
//    public String tokenGenerator(UUID userId, Set<Role> roles) {
//        Date expireDate = new Date(new Date().getTime() + environment.getProperty("jwt.expire-date"));
//        return Jwts
//                .builder()
//                .setSubject(userId.toString())
//                .setIssuedAt(new Date())
//                .setExpiration(expireDate)
//                .signWith(SignatureAlgorithm.HS512, environment.getProperty("jwt.secret")).compact();
//    }

    public String createToken(String username, Set<Role> roles) {


        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", roles.stream()
                .map(s -> new SimpleGrantedAuthority(s.getAuthority()))
                .collect(Collectors.toList()));

        Time now = new Time(System.currentTimeMillis());
        Time validity = new Time(now.getTime() + Long.parseLong(Objects.requireNonNull(environment.getProperty("jwt.expire-date"))));

        return Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("jwt.secret"))//
                .compact();
    }
}
