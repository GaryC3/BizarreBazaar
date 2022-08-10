package com.bb.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity  // role-based access control (RBAC) to methods.. not just URL
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

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
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(dataSource);
		// part below, i can use this to make certain calls from tables to do that authentication, this is the jdbc type
//			.usersByUsernameQuery(
//					"select username, password, enabled from userlist where username =?"
//					)
//			.authoritiesByUsernameQuery(
//					"select username, authority from authorities where username =?"
//					);
			
	}
	
	@Bean
	public PasswordEncoder getPassworldEncoder(){
		// can return any encoder we want, noOp doesnt do any encoding, dont use 
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// most restrictive on top
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/gameList").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("USER", "ADMIN")
			.antMatchers("/").permitAll()
			.and().formLogin();
		
//			.antMatchers("/").permitAll()
//			.antMatchers("/userlist").permitAll()
//			.antMatchers("/gameList").hasRole("USER")
//			.antMatchers("/invoice").hasRole("USER")
//			.antMatchers("/invoicelines").hasRole("USER")
//			.
//			.antMatchers("/**").hasRole("ADMIN") //restricting access to all parts to only user and admin, will change later
////			.antMatchers("/userlist").permitAll();
////			.antMatchers("/").permitAll() //all are allowed on the default page
//			.and().formLogin();
//		http.csrf().disable().httpBasic(); // not-prod
//		http.authorizeRequests().mvcMatchers("/login-check").hasAnyRole("USER");
//		http.authorizeRequests().mvcMatchers("/artist/**").hasAnyRole("USER");
//		http.authorizeRequests().mvcMatchers("/album/**").hasAnyRole("ADMIN");
//		http.authorizeRequests().mvcMatchers("/tracks/**").hasAnyRole("ADMIN");
//		http.authorizeRequests().mvcMatchers("/**").permitAll();
//		http.authorizeRequests().anyRequest().permitAll();
//		http.logout().deleteCookies("custom-cookie").invalidateHttpSession(false); // POST /logout
//		// CSRF - 
//		// 1. login to Bank of America (session, cookie)
//		// 2. hacker send you an email with link
//		// 3. click link href=malicious JS   POST boa.com/api/transfer/your-acct/myacct/balance
//		// 4. YOU initiated the request
//		
//		// generate a random csrf_token. Unsafe methods MUST contain the CSRF token or-else request is denied
//		
	}
	
}