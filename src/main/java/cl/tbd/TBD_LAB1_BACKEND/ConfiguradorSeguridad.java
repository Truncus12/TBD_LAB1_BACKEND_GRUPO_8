package cl.tbd.TBD_LAB1_BACKEND;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

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
            .addFilterBefore(new OncePerRequestFilter() {
                @Override
                public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                        throws IOException, ServletException {
                    Cookie[] cookies = request.getCookies();

                    if(cookies == null){
                        chain.doFilter(request, response);
                        return;
                    }

                    for(Cookie cookie : cookies){
                        System.out.println("Leyendo cookie: " + cookie.getName());
                    }
                    
                    UserDetails usuario = new UserDetails() {
                        @Override
                        public Collection<? extends GrantedAuthority> getAuthorities() {
                            return null;
                        }
                        @Override
                        public String getPassword() {
                            return "123";
                        }

                        @Override
                        public String getUsername() {
                            return "asd";
                        }

                        @Override
                        public boolean isAccountNonExpired() {
                            return true;
                        }

                        @Override
                        public boolean isAccountNonLocked() {
                            return true;
                        }

                        @Override
                        public boolean isCredentialsNonExpired() {
                            return true;
                        }

                        @Override
                        public boolean isEnabled() {
                            return true;
                        }
                        
                    };
                    
                    UsernamePasswordAuthenticationToken autenticacion = new UsernamePasswordAuthenticationToken(
                        usuario, null, usuario.getAuthorities()); 
                    autenticacion.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(autenticacion);
                    System.out.println("ASDASDSADASDA");
                    chain.doFilter(request, response);
                }
                
            }, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    

	@Bean
	JwtDecoder jwtDecoder() {
        return new JwtDecoder() {
            @Override
            public Jwt decode(String token) throws JwtException {
                System.out.println("Decodificando");

                DecodedJWT jwt = JWT
                    .require(Algorithm.HMAC256("asd123"))
                    .build()
                    .verify(token);

                System.out.println("Decodificando token: " + token);
                
                Map encabezado = new HashMap<>();
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
                System.out.println("Codificando JWT");

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
