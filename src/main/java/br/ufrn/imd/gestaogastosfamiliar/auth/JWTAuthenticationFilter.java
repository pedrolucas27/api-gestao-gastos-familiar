package br.ufrn.imd.gestaogastosfamiliar.auth;

import br.ufrn.imd.gestaogastosfamiliar.model.Membro;
import br.ufrn.imd.gestaogastosfamiliar.util.JWTUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        setFilterProcessesUrl("/api/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationRequest(request);
        setDetails(request, authenticationToken);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        MembroDetailsData membroDetailsData = (MembroDetailsData) authResult.getPrincipal();

        response.setStatus(200);
        response.getWriter().write(buildToken(membroDetailsData));

        response.getWriter().flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(401);
        response.setContentType("application/json");
        response.getWriter().write(failed.getMessage());
    }

    private UsernamePasswordAuthenticationToken getAuthenticationRequest(HttpServletRequest request)
            throws AuthenticationException {
        try {
            Membro membro = new ObjectMapper().readValue(request.getInputStream(), Membro.class);
            return new UsernamePasswordAuthenticationToken(membro.getEmail(), membro.getSenha(), new ArrayList<>());
        } catch (IOException e) {
            throw new RuntimeException("Failed to authenticate user", e);
        }
    }

    private String buildToken(MembroDetailsData membroDetailsData) {
        return JWT.create()
                .withClaim("email", membroDetailsData.getMembro().getEmail())
                .withClaim("usuarioId", membroDetailsData.getMembro().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + (jwtUtil.getExpiration() * 1000)))
                .sign(Algorithm.HMAC512(jwtUtil.getSecret()));
    }
}
