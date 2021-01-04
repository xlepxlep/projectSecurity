package com.example.projectSecurity.security;

import com.example.projectSecurity.principals.UserPrincipalDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserPrincipalDetailsService citizenPrincipalDetailsService;
    //private EmployeePrincipalDetailsService employeePrincipalDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     UserPrincipalDetailsService citizenPrincipalDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.citizenPrincipalDetailsService = citizenPrincipalDetailsService;
        //this.employeePrincipalDetailsService = employeePrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    //method that secures things
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests() //we want to authorize requests
                .antMatchers("/api/registration", "/api/getAllUsers", "/api/delAll").anonymous()
                .antMatchers("/api/employee/**").hasRole(ApplicaationUserRole.EMPLOYEE.name())
                .antMatchers("/api/citizen/**").hasRole(ApplicaationUserRole.CITIZEN.name())
                .antMatchers("/api/admin/**").hasRole(ApplicaationUserRole.ADMIN.name())
                .anyRequest() //any request
                .authenticated() //any request must be authenticated
                .and()
                .httpBasic(); //we authenticate with http basic
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(this.citizenPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails xlep = User.builder()
//                .username("xlep")
//                .password(passwordEncoder.encode("pas"))
//                .roles("CITIZEN")
//                .build();
//
//        UserDetails atha = User.builder()
//                .username("atha")
//                .password(passwordEncoder.encode("pas1"))
//                .roles("EMPLOYEE") // = ROLE_USER
//                .build();
//
//        UserDetails intzi = User.builder()
//                .username("intzi")
//                .password(passwordEncoder.encode("pas2"))
//                .roles("ADMIN") // = ROLE_USER
//                .build();
//
//        return new InMemoryUserDetailsManager(
////                xlep,
////                atha,
////                intzi
//        );


}

