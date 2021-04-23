package com.example.lecture15;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ConfigAuth extends WebSecurityConfigurerAdapter {


/*   // @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsManager= new InMemoryUserDetailsManager();
        UserDetails yavorUser = User.withUsername("yavor")
                .password("1234")
                .roles("USER")
                .build();
        userDetailsManager.createUser(yavorUser);
        return userDetailsManager;
    }*/

    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                .withUser(User.withUsername("yavor")
                        .password(passwordEncoder().encode("1234"))
                        .roles("USER"))
                .withUser(User.withUsername("test")
                        .password("1234")
                        .roles("USER"));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * /api/hello/ -  /api/hello/   x/api/hello/world
         * /api/hello/*   /api/hello/   /api/hello/world    x /api/hello/world/second
         * /api/hello/**   /api/hello/   /api/hello/world     /api/hello/world/second
         */
        http.httpBasic();
        http.authorizeRequests().antMatchers("/api/**").hasAnyRole("USER");
        http.csrf().disable().authorizeRequests()
                .antMatchers("/h2-console/**").permitAll();
        http.headers()
                .frameOptions()
                .sameOrigin();
    }
}
