package com.sda.switter.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SwitterSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                    .permitAll()
                .and()
                    .authorizeRequests()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/xyz","/h2-console/**","/favicon.ico","/messages/home"
                        ,"/css/**", "/js/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .frameOptions()
                .sameOrigin().and().csrf().disable();
    }

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/css/**", "/js/**");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
