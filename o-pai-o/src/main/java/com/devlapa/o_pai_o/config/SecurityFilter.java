package com.devlapa.o_pai_o.config;

import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import com.devlapa.o_pai_o.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    @Lazy
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if(token != null){
            var login = tokenService.validateToken(token);


            if (login != null && !login.isEmpty()) {
                var usuarioOptional = usuarioRepository.findByLogin(login);

                if (usuarioOptional.isPresent()) {
                    var usuario = usuarioOptional.get();

                    System.out.println("--------------------------------REQUISIÇÃO DETECTADA--------------------------------");
                    System.out.println("Usuário Logado: " + usuario.getLogin());
                    System.out.println("Perfil no Banco: " + usuario.getPerfil());
                    System.out.println("Authorities (Roles) enviadas ao Spring: " + usuario.getAuthorities());
                    System.out.println("----------------------------------------------------------------------------------");
                    // --------------------------------------
                    var authorities = usuario.getAuthorities();

                    System.out.println("Filtro: Usuario " + login + " tentando acesso com: " + authorities);

                    var authentication = new UsernamePasswordAuthenticationToken(
                            usuario,
                            null,
                            authorities
                    );


                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")) return null;
        return authHeader.replace("Bearer ", "");
    }
}