package hh.swd20.Bookstore;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import hh.swd20.Bookstore.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authman) throws Exception{
		authman.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		//.antMatchers("/booklist").permitAll() //tänne voi laittaa jos johonkin saa mennä ilman sisäänkirjautumista
		//.antMatchers("/delete/**").hasRole("ADMIN") //vain admin saa mennä tänne, in-memory users
		.antMatchers("/delete/**").hasAuthority("ADMIN") //vain admin saa mennä tänne, user entities
		.anyRequest().authenticated()
		.and()
	.formLogin()
		//.loginPage("/login") //login sivun endpoint jos löytyy
		.defaultSuccessUrl("/booklist", true)
		.permitAll()
		.and()
	.logout()
		.permitAll()
		.and()
	.httpBasic();
		
		return http.build();
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<UserDetails>();
		
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails user1 = User
				.withUsername("user")
				.password(passwordEncoder.encode("fuser"))
				.roles("USER")
				.build();
		
		users.add(user1);
		
		UserDetails user2 = User
				.withUsername("admin")
				.password(passwordEncoder.encode("fadmin"))
				.roles("USER", "ADMIN")
				.build();
		
		users.add(user2);
		
		return new InMemoryUserDetailsManager(users);
	}
	*/
}
