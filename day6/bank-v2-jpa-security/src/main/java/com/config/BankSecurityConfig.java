package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	@Autowired
	private DataSource dataSource;
	
	
	
	
	
	public BankSecurityConfig() {
	System.out.println("BAnk Security Configure created...");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	System.out.println("In autmangerbuilder :");
	
	

	auth.jdbcAuthentication()
	.passwordEncoder(new BCryptPasswordEncoder())
	.dataSource(dataSource);
	
	
	
	
	/* auth.inMemoryAuthentication()
	 .withUser("RAM").password("{noop}RAM").roles("ADMIN").and()
	 .withUser("RAHIM").password("{noop}RAHIM").roles("STUDENT").and()
	 .withUser("DAVID").password("{noop}DAVID").roles("TEACHER");
     */
	
	
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	System.out.println("http security configure");
		
		http
		.cors()
		.disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/spring/hello").hasRole("STUDENT")
		.antMatchers(HttpMethod.GET, "/spring/greet").hasAnyRole("STUDENT","TEACHER")
		.antMatchers(HttpMethod.GET, "/spring/today").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
        .and()
        .formLogin();
        //.httpBasic();
	
	
	
	}
	
		
	
	
	
	
}
