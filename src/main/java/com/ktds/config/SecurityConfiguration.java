package com.ktds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //  PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        BCryptPasswordEncoder encoder = passwordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user1")
                //.password("12345678")
                .password(encoder.encode("12345678"))
                //.passwordEncoder("12345678")
                .roles("ADMIN", "USER");

                int i = 0;
                while (i < 5) {
                    String password = "12345678";
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    String hashedPassword = passwordEncoder.encode(password);

                    System.out.println(hashedPassword);
                    i++;
                }
            
             
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/token")).disable();

    }

    @Bean
    protected AccessDeniedHandler accessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }
}
