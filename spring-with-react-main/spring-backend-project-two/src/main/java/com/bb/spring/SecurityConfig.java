package com.bb.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableGlobalMethodSecurity  // role-based access control (RBAC) to methods.. not just URL
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired // Spring Data JPA should have a datasource already
	private DataSource datasource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// Spring Security Filter logic (pseudo)
	// 1. http-req Authentication Header, filter extract header/ decode base64 Authentication header
	// 2. hashes password with Bcrypt -  $2a$10$iCyW/yDkb6URKSeVwKrQt.FoIf5TJs87OkZfShVWuMQJWSHG83nGe
	// 3. jdbc auth, select username, password, enabled from users where username = ?
	// 4. !enabled? 401 : next
	// 5. $2a$10$iCyW/yDkb6URKSeVwKrQt.FoIf5TJs87OkZfShVWuMQJWSHG83nGe check with the password value from DB
	// 6. authenticated or not?
	// 7. Principal (user currently logged in). stores in HttpSession (any data needs to be Serializable) 
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder);
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic(); // not-prod
		http.authorizeRequests().mvcMatchers("/").hasAnyRole("USER");
		http.authorizeRequests().mvcMatchers("/sign").hasAnyRole("USER");
		http.authorizeRequests().mvcMatchers("/browse").hasAnyRole("ADMIN");
		http.authorizeRequests().mvcMatchers("/owned").hasAnyRole("ADMIN");
		http.logout().deleteCookies("custom-cookie").invalidateHttpSession(false); // POST /logout
		// CSRF - 
		// 1. login to Bank of America (session, cookie)
		// 2. hacker send you an email with link
		// 3. click link href=malicious JS   POST boa.com/api/transfer/your-acct/myacct/balance
		// 4. YOU initiated the request
		
		// generate a random csrf_token. Unsafe methods MUST contain the CSRF token or-else request is denied
		
	}
	
}