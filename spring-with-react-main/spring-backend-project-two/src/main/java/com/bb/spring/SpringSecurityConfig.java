package com.bb.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity  // role-based access control (RBAC) to methods.. not just URL
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	
//	@Autowired // Spring Data JPA should have a datasource already
//	private DataSource datasource;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	// Spring Security Filter logic (pseudo)
	// 1. http-req Authentication Header, filter extract header/ decode base64 Authentication header
	// 2. hashes password with Bcrypt -  $2a$10$iCyW/yDkb6URKSeVwKrQt.FoIf5TJs87OkZfShVWuMQJWSHG83nGe
	// 3. jdbc auth, select username, password, enabled from users where username = ?
	// 4. !enabled? 401 : next
	// 5. $2a$10$iCyW/yDkb6URKSeVwKrQt.FoIf5TJs87OkZfShVWuMQJWSHG83nGe check with the password value from DB
	// 6. authenticated or not?
	// 7. Principal (user currently logged in). stores in HttpSession (any data needs to be Serializable) 
	
//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder);
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/**") // goes to default or home page
			.permitAll()  // no credentials needed for for page
//			.antMatchers("/signup")
//			.permitAll()	// all users can go to sign up
//			.antMatchers("/ownedgames") //gamelist only accessible by role user, note might have to do /pagename from frontend
//			.hasAuthority("user")
//			.antMatchers("/purchase") //gamelist only accessible by role user, note might have to do /pagename from frontend
//			.hasAuthority("user")
//			.antMatchers("/confirmation") //gamelist only accessible by role user, note might have to do /pagename from frontend
//			.hasAuthority("user")
//			.antMatchers("/userlist")
//			.hasAuthority("admin")
//			.antMatchers("/merchant")
//			.hasAuthority("admin") // only admin has access to merchant page
//			.anyRequest()
//			.hasAnyRole("admin", "user")
			.and()
			.httpBasic();
			
//		http.csrf().disable().httpBasic(); // not-prod
//		http.authorizeRequests().mvcMatchers("/login-check").hasAnyRole("user");
//		http.authorizeRequests().mvcMatchers("/gameList/**").hasAnyRole("user");
//		http.authorizeRequests().mvcMatchers("/**").hasAnyRole("user");
//		http.authorizeRequests().mvcMatchers("/invoice/**").hasAnyRole("user");
//		http.authorizeRequests().mvcMatchers("/invoicelines/**").hasAnyRole("user");
//		http.authorizeRequests().mvcMatchers("/**").permitAll();
//		http.authorizeRequests().anyRequest().permitAll();
//		http.logout().deleteCookies("custom-cookie").invalidateHttpSession(false); // POST /logout
		// CSRF - 
		// 1. login to Bank of America (session, cookie)
		// 2. hacker send you an email with link
		// 3. click link href=malicious JS   POST boa.com/api/transfer/your-acct/myacct/balance
		// 4. YOU initiated the request
		
		// generate a random csrf_token. Unsafe methods MUST contain the CSRF token or-else request is denied
		
	}
	
}