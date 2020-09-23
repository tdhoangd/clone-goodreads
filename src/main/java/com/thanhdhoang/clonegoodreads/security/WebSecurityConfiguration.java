package com.thanhdhoang.clonegoodreads.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("thanh")
//                .password("$2a$10$NzPkvUN96SHR/UADqjR6EuKX9R1nLwoCuoB.ABcWduCYzpN/T.oE2")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("admin")
//                .password("password")
//                .authorities("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/login", "/logout", "logout").permitAll()
                .antMatchers("/author", "/book", "/genres").permitAll()
                .antMatchers("/author/new", "/author/**/edit")
                    .hasAnyRole("EDITOR")

//                .and().authorizeRequests()
//                    .antMatchers("/static/css/**", "/css/**", "/images/**").permitAll()
//                .and().authorizeRequests()
//                    .antMatchers("/author/new").hasRole("USER")
//                .antMatchers("/author/**/edit").hasRole("USER")
                .anyRequest().permitAll()
                .and().formLogin().permitAll()
                .and().logout().logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/403");
//        http.csrf().disable();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
