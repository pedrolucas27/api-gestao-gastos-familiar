package br.ufrn.imd.gestaogastosfamiliar.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JWTUtil {
    public static final String TOKEN_PREFIX = "Bearer ";

    @Value("e3c885d6-c738-49b1-9058-0cde56f57e2b")
    String secret;

    @Value("86400000")
    Long expiration;

    public String getSecret() {
        return secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public UUID getUsuarioIdFromRequest(HttpServletRequest request) {
        String token = getTokenFromRequest(request);
        return UUID.fromString(getUserIdFromTokenJWT(token));
    }


    public String getTokenFromRequest(HttpServletRequest request) {
        String authorization = getAuthorizationFromHeader(request);
        return getTokenFromAuthorizationHeader(authorization);
    }

    public String getUserIdFromTokenJWT(String token) {
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token)
                .getClaim("usuarioId").toString().replace("\"", "")
                .replace(" ", "");
    }

    public String getFamiliaIdFromTokenJWT(String token) {
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token)
                .getClaim("familiaId").toString().replace("\"", "")
                .replace(" ", "");
    }

    public String getCpfFromTokenJWT(String token) {
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token)
                .getClaim("cpf").toString().replace("\"", "")
                .replace(" ", "");
    }

    private String getTokenFromAuthorizationHeader(String header) {
        return header.replace(TOKEN_PREFIX, "");
    }

    public String getAuthorizationFromHeader(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }
}
