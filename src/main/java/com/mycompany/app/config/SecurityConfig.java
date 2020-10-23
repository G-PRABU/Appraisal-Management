package com.mycompany.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mycompany.app.service.EmployeeDetailsService;


@Configuration
@ComponentScan("com.mycompany.app")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private EmployeeDetailsService employeeDetailService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(employeeDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/manager/**").hasAuthority("MANAGER")
		.antMatchers("/hr/**").hasAuthority("HR")
		.antMatchers("/employee/**").hasAuthority("EMPLOYEE")
		.and()
		.formLogin().usernameParameter("username").passwordParameter("password")
		.and()
		.logout()
		.and()
		.csrf();
	}
}
