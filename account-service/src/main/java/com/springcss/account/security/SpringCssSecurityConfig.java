package com.springcss.account.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringCssSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Override
	// protected void configure(AuthenticationManagerBuilder builder) throws
	// Exception {
	//
	// builder.inMemoryAuthentication().withUser("springcss_user").password("password1").roles("USER").and()
	// .withUser("springcss_admin").password("password2").roles("USER", "ADMIN");
	// }

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from Users " + "where username=?")
				.authoritiesByUsernameQuery("select username, authority from UserAuthorities " + "where username=?")
				.passwordEncoder(new BCryptPasswordEncoder());

	}
	
//	@Autowired
//	SpringCssUserDetailsService springCssUserDetailsService;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//   	 	auth.userDetailsService(springCssUserDetailsService);
//	}

	

	@Override
	public void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests()
//		.antMatchers("/accounts/**")
//		.authenticated();
		
//		http.authorizeRequests()
//        .antMatchers("/accounts")
//        .access("hasRole('ROLE_USER')");


		
		http.authorizeRequests()
        	.antMatchers(HttpMethod.DELETE, "accounts/**")
        	.hasRole("ADMIN")
			.anyRequest()
			.authenticated();
		
//		http.authorizeRequests()
//	        .antMatchers("/design", "/orders")
//	          .access("hasRole('ROLE_USER')");
	}

}
