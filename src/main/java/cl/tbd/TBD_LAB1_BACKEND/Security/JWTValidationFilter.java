package cl.tbd.TBD_LAB1_BACKEND.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Usuario;

public class JWTValidationFilter extends OncePerRequestFilter{
    @Override
    public void doFilterInternal(
            HttpServletRequest request, 
            HttpServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        
        // Verifica si tiene cookies
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            chain.doFilter(request, response);
            return;
        }

        // Busca entre las cookies, la cookie de sesión
        String token = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token_sesion")){
                token = cookie.getValue();
                break;
            }
        }

        if(token == null){
            chain.doFilter(request, response);
            return;
        }

        // Crea detalles de usuario basado en el JWT        
        UserDetails usuario = new Usuario();
        
        UsernamePasswordAuthenticationToken autenticacion = new UsernamePasswordAuthenticationToken(
            usuario, null, usuario.getAuthorities()
        );
        autenticacion.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );

        // Agrega la autenticación del JWT al contexto para autorizarse
        SecurityContextHolder.getContext().setAuthentication(autenticacion);
        chain.doFilter(request, response);
    }
}
