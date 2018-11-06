package com.sheepdivide.master.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //database
    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    //database
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?"); //virker denne korrekt?
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    //.anyRequest().authenticated() //Giver en bruger med gyldigt login adgang til ALLE programmets funktioner.
                    //.antMatchers("/login.html").permitAll()  // "/index", "/login" //"/shared/**"  .hmtl for at få siderne vist til annonyme?
                    //.antMatchers("/authorized/**").hasAnyRole("USER")
                    .antMatchers("/authorized/**").access("hasRole('USER')") //'USER'
                    .antMatchers("/authorized/**").authenticated() //Giver også brugeren adgang til alt? Hvad hvis vi får ADMIN bruger?
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login.html")
                    .defaultSuccessUrl("/authorized/home.html",true)
                    .usernameParameter("username").passwordParameter("password")
                    .permitAll() //slet permitall
//                .and()
//                    .rememberMe()  //tilføj måske rememberMe token.
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login.html")
                    .permitAll(); //slet permitall

        //guiden
//                    .authorizeRequests()
//                    .antMatchers("/login").permitAll()
//                    .antMatchers("/authorized/**").access("hasRole('USER')")
//                    //.anyRequest().authenticated()
//                .and()
//                    .formLogin().loginPage("/login.html")
//                    .usernameParameter("username").passwordParameter("password")
//                .and()
//                    .logout().logoutSuccessUrl("/login.html")
//                .and()
//                    .exceptionHandling()
//                .and()
//                    .csrf();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/img/**", "sheepIcon/**");
    }

    //In memory user
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws  Exception{
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
}
