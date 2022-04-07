package com.example.millcreekhoa.config;

import com.example.millcreekhoa.data.CurrentUser;
import com.example.millcreekhoa.repo.InMemorySessionRegistry;
import com.example.millcreekhoa.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SessionFilter extends OncePerRequestFilter {

    @Autowired
    private InMemorySessionRegistry sessionRegistry;

    @Autowired
    private CurrentUserService currentUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String sessionId = request.getHeader(HttpHeaders.AUTHORIZATION);


        if (sessionId == null || sessionId.length() == 0) {
            filterChain.doFilter(request, response);
            return;
        }

        final String username = sessionRegistry.getUsernameForSession(sessionId);

        if (username == null) {
            filterChain.doFilter(request,response);
            return;
        }

       CurrentUser currentUser =  currentUserService.loadUserByUsername(username);

       final UsernamePasswordAuthenticationToken auth =  new UsernamePasswordAuthenticationToken(
                currentUser,
                null,
                currentUser.getAuthorities()
        );


       auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request,response);
    }
}
