package cl.cursospring.curso_spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cl.cursospring.curso_spring.jwt.JwtTokenFilter;
import jakarta.servlet.http.HttpServletResponse;


@Configuration
@EnableWebSecurity
public class Seguridad {


    @Autowired
    private JwtTokenFilter jwtTokenFilter;


    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        /*
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(req -> req.anyRequest().permitAll());
        http.sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        */

         
        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //http.exceptionHandling().authenticationEntryPoint((req, res, ex) -> 
            //res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/login").permitAll()
            .requestMatchers("/api/mongodb/**").permitAll()
            .requestMatchers("/jpa-repository/**").permitAll().anyRequest().authenticated())
            .exceptionHandling(exHandling -> exHandling.authenticationEntryPoint((req, res, ex) ->
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED)));
        
        return http.build();
    }
}
