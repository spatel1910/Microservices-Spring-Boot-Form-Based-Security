package com.employeeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class MySecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
            UserDetails user= User.withDefaultPasswordEncoder()
                    .username("root")
                    .password("root")
                    .roles("USER")
                    .username("admin")
                    .password("admin")
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(user);
        }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authorizeHttpRequests) -> authorizeHttpRequests.requestMatchers("/employee").hasRole("USER")
                        
                )
                .formLogin(withDefaults());
        return http.build();

    }
}
