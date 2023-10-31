package com.example.testeSecurity1.serv;

import com.auth0.jwt.algorithms.Algorithm;
import com.example.testeSecurity1.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {
        return com.auth0.jwt.JWT.create()
                .withIssuer("Produtos")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("api-security-java"));
    }

    public String getSubject(String token) {
        return com.auth0.jwt.JWT.require(Algorithm.HMAC256("api-security-java"))
                .withIssuer("Produtos")
                .build().verify(token).getSubject();
    }
}
