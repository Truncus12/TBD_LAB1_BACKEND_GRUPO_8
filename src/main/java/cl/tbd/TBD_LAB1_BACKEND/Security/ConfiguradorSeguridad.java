package cl.tbd.TBD_LAB1_BACKEND.Security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtEncodingException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Configuration
public class ConfiguradorSeguridad {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .antMatchers("/api/auth").permitAll()
                .anyRequest().authenticated()
            )
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .exceptionHandling((exceptions) -> exceptions
                    .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                    .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
            )
            .addFilterBefore(new JWTValidationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    

	@Bean
	JwtDecoder jwtDecoder() {
        return new JwtDecoder() {
            @Override
            public Jwt decode(String token) throws JwtException {
                DecodedJWT jwt = JWT
                    .require(Algorithm.HMAC256("asd123"))
                    .build()
                    .verify(token);

                Map<String, Object> encabezado = new HashMap<>();
                encabezado.put("alg", "HS256");
                encabezado.put("typ", "JWT");

                return new Jwt(token, null, null, encabezado, (Map) jwt.getClaims());
            }
        };
	}

	@Bean
	JwtEncoder jwtEncoder() {
        return new JwtEncoder() {
            @Override
            public Jwt encode(JwtEncoderParameters parameters) throws JwtEncodingException {
                String token = JWT
                    .create()
                    .withClaim("rol", "voluntario")
                    .withClaim("id_voluntario", 1)
                    .sign(Algorithm.HMAC256("asd123"));
                
                return new Jwt(
                    token, 
                    null, 
                    null, 
                    null, 
                    null
                );
            }
            
        };
	}
}
