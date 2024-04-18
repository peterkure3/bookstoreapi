package com.example.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
  securedEnabled = true,
  jsr250Enabled = true,
  prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/api/bookstore/**")
      .authenticated() // Define URL patterns that require authentication
      .anyRequest()
      .permitAll() // Allow access to other URLs without authentication
      .and()
      .formLogin() // Use form-based authentication
      .loginPage("/login") // Customize the login page URL if needed
      .permitAll() // Allow access to the login page without authentication
      .successHandler(successHandler()) // Customize authentication success handling if needed
      .and()
      .logout() // Enable logout
      .permitAll(); // Allow access to the logout URL without authentication
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
    throws Exception {
    auth
      .inMemoryAuthentication() // Configure in-memory authentication
      .withUser("user")
      .password(passwordEncoder().encode("password"))
      .roles("USER"); // Define user credentials
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // Use BCryptPasswordEncoder for password encoding
  }

  @Bean
  public AuthenticationSuccessHandler successHandler() {
    return new SimpleUrlAuthenticationSuccessHandler(); // Use SimpleUrlAuthenticationSuccessHandler for authentication success handling
  }
}
