package Harvest.security;

import Harvest.Models.AppUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtConverter {

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final String ISSUER = "Harvest-Fetch-API";
    private final int EXPIRATION_MINUTES = 15;
    private final int EXPIRATION_MILLIS = EXPIRATION_MINUTES * 60 * 1000;

    public AppUser tokenToUser(String token) {

        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        try {
            // 4. Use JJWT classes to read a token.
            Jws<Claims> jws = Jwts.parserBuilder()
                    .requireIssuer(ISSUER)
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.substring(7));

            String username = jws.getBody().getSubject();
            List<String> authorities =  jws.getBody().get("authorities", List.class);
            int appUserId = jws.getBody().get("appUserId", Integer.class);

            AppUser user = new AppUser();
            user.setAppUserId(appUserId);
            user.setUserName(username);
            user.addAuthorities(authorities);
            return user;

        } catch (JwtException e) {
            // 5. JWT failures are modeled as exceptions.
            System.out.println(e);
        }

        return null;

    }

    public String userToToken(AppUser user) {

        String authorities = user.getAuthorities().stream()
                .map(i -> i.getAuthority())
                .collect(Collectors.joining(","));


        return Jwts.builder()
                .setIssuer(ISSUER)
                .setSubject(user.getUsername())
                .claim("authorities", authorities)
                .claim("appUserId", user.getAppUserId())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key)
                .compact();
    }
}
