package org.alvarowau.anqhv.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity // Necesario para la seguridad reactiva con Spring WebFlux (usado por Gateway)
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                // Deshabilita CSRF para APIs REST que usan tokens (los tokens ya protegen contra esto)
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                // Configura las reglas de autorización para las peticiones entrantes
                .authorizeExchange(exchanges -> exchanges
                        // Rutas que pueden ser accedidas sin autenticación (públicas)
                        // Esto es vital para el endpoint de tu futuro servicio de autenticación y el dashboard de Eureka
                        .pathMatchers("/auth/**").permitAll() // Para tu servicio de autenticación (ej. /auth/login)
                        .pathMatchers("/eureka/**").permitAll() // Para acceder al dashboard de Eureka (si lo expones)
                        .pathMatchers("/actuator/**").permitAll() // Para los endpoints de monitoreo de Spring Boot Actuator
                        // Cualquier otra petición DEBE estar autenticada
                        .anyExchange().authenticated()
                )
                // Habilita el servidor de recursos OAuth2 para validar JWTs
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwtSpec -> jwtSpec.jwkSetUri("http://localhost:9000/oauth2/jwks")) // ¡La misma URL que en application.yml!
                );
        return http.build();
    }
}