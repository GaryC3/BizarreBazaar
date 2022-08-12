package com.bb.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.bb.spring.repositories.UserListRepo;

@Configuration
//@EnableGlobalMethodSecurity  // role-based access control (RBAC) to methods.. not just URL
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserListRepo userListRepo;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(username -> userListRepo.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + username+ " not found")));
	}

	

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic(); // not-prod
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.authorizeRequests().mvcMatchers("/login-check").hasAnyRole("USER");
//		http.authorizeRequests().mvcMatchers("/artist/**").hasAnyRole("USER");
//		http.authorizeRequests().mvcMatchers("/album/**").hasAnyRole("ADMIN");
//		http.authorizeRequests().mvcMatchers("/tracks/**").hasAnyRole("ADMIN");
		http.authorizeRequests().mvcMatchers("/**").permitAll();
		http.authorizeRequests().anyRequest().permitAll();
		http.logout().deleteCookies("custom-cookie").invalidateHttpSession(false); // POST /logout
		// CSRF - 
		// 1. login to Bank of America (session, cookie)
		// 2. hacker send you an email with link
		// 3. click link href=malicious JS   POST boa.com/api/transfer/your-acct/myacct/balance
		// 4. YOU initiated the request
		
		// generate a random csrf_token. Unsafe methods MUST contain the CSRF token or-else request is denied
		
	}
	
}