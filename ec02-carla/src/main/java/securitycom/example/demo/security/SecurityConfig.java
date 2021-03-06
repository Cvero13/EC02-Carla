package securitycom.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		auth.inMemoryAuthentication().withUser("PROFESOR").password(encoder().encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("ALUMNO").password(encoder().encode("123")).roles("USER");
		
		//auth.userDetailsService().passwordEncoder(encoder());
		
	}

	
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * http.authorizeRequests()
		 * .antMatchers("/cliente/v1/*").access("hasRole('ADMIN')")
		 * .antMatchers("/producto/v1/*").access("hasRole('USER')") .and() .httpBasic()
		 * .and() .csrf().disable();
		 */
		

	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
