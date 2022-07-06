package com.idat.MayoServicioPrueba.security;

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
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailService service;
	/*
	@Autowired
	private TokenFilter filter;
	*/
	@Autowired
	private EntryPoint entrypoint;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		auth.inMemoryAuthentication().withUser("profesor").password(encriptado().encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("estudiante").password(encriptado().encode("123")).roles("ESTUDIANTE");
		*/
		
		//usare los usuarios de mi bd
		auth.userDetailsService(service).passwordEncoder(encriptado());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		//accesss = a partir de q rol van a tener acceso
		http.authorizeRequests()		
		.antMatchers("/producto/v1/**").access("hasRole('ADMIN')")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
		
		
		http.authorizeRequests()
			.antMatchers("/crearToken").permitAll()//todos los usuarios van a poder acceder aqui
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(entrypoint)//la excepcion q creamos
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
			.csrf().disable();
			*/
	}
	
	
	@Bean
	public TokenStore store() {
		return new InMemoryTokenStore();
	}
	
	
	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	

}
