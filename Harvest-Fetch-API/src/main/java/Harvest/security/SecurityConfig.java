package Harvest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final JwtConvertor converter;

    public SecurityConfig(JwtConvertor converter) {
        this.converter = converter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           AuthenticationConfiguration config) throws Exception {
        http.csrf().disable();
        http.cors();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/authenticate").permitAll()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/**").hasAnyAuthority("FARMER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyAuthority("FARMER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyAuthority("ADMIN")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    public AuthenticationManager manager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
