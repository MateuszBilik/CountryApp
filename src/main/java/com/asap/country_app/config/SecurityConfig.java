package com.asap.country_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/city", "/css/**", "/", "/login","/mylocation", "/js/**", "/pictures/**", "/templates/**", "/userl", "/user", "/location").permitAll()
//                .antMatchers("/mylocation").hasRole("USER")
                .anyRequest().authenticated()
                .and()
//TODO loginpage
                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .usernameParameter("login")
//                .passwordParameter("password")
                .defaultSuccessUrl("/")

                .and()
                .logout().logoutSuccessUrl("/");

        http.csrf().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}user").roles("USER");
//    }
}
