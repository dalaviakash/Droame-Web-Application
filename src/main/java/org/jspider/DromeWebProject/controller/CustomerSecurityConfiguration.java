package org.jspider.DromeWebProject.controller;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class CustomerSecurityConfiguration extends WebSecurityConfigurerAdapter {
    //Authentication


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser((user.username("Drome").password("Drome@123").roles("ADMIN")));//this is user name and password for admin


    }

    //Autherization

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()

                .antMatchers("/admin").hasRole("ADMIN")//only access to giv admin

                .and().formLogin();

    }
}
