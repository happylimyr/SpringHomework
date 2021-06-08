package com.nulp.bat.travelagency.config;

import com.nulp.bat.travelagency.filter.JwtFilter;
import com.nulp.bat.travelagency.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String admin = "ADMIN";
    private static final String customer = "CUSTOMER";
    private static final String manager = "MANAGER";

    @Autowired
    private UserDetailsServiceImpl userDetails;

    @Autowired
    private JwtFilter jwtFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/api/v1/tour").permitAll()
                .antMatchers("/api/v1/address").hasAuthority(admin)
                .antMatchers("/api/v1/city").hasAuthority(admin)
                .antMatchers("/api/v1/country").hasAuthority(admin)
                .antMatchers("/api/v1/hotel").hasAuthority(admin)
                .antMatchers("/api/v1/hoteltype").hasAuthority(admin)
                .antMatchers("/api/v1/order").hasAuthority(admin)
                .antMatchers("/api/v1/personaldata").hasAuthority(admin)
                .antMatchers("/api/v1/role").hasAuthority(admin)
                .antMatchers("/api/v1/status").hasAuthority(admin)
                .antMatchers("/api/v1/tourtype").hasAuthority(admin)
                .antMatchers("/api/v1/user").hasAnyAuthority(customer,admin)
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }

}
