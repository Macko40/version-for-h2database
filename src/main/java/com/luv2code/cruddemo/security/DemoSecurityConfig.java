package com.luv2code.cruddemo.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class DemoSecurityConfig{
 // add support for JDBC .. no more hardcoded users :-)

  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource){
    return new JdbcUserDetailsManager(dataSource);
  }


//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.authorizeRequests(configurer ->
//        configurer
//            .antMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
//            .antMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//            .antMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//            .antMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
//            .antMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
//
//    );
//    // use HTTP Basic authentication
//    http.httpBasic(Customizer.withDefaults());
//
//    // disable Cross Site Request forgery (CSRF)
//    // in general , not required for stateless REST APIs that use POST, PUT , DELETE and/or PATCH
//    http.csrf(csrf -> csrf.disable());
//
//    return http.build();
//  }

  /*
  @Bean

  public InMemoryUserDetailsManager userDetailManager() {
    UserDetails john = User.builder()
        .username("john")
        .password("{noop}test123")
        .roles("EMPLOYEE")
        .build();

    UserDetails mary = User.builder()
        .username("mary")
        .password("{noop}test123")
        .roles("EMPLOYEE", "MANAGER")
        .build();
    UserDetails susan = User.builder()
        .username("susan")
        .password("{noop}test123")
        .roles("EMPLOYEE", "MANAGER", "ADMIN")
        .build();

    return new InMemoryUserDetailsManager(john, mary, susan);
  }
*/

}
