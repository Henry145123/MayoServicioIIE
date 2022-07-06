package com.idat.MayoServicioPrueba.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenStore store;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory()
			.withClient("queridoprofesor")
			.secret(new BCryptPasswordEncoder().encode("queridoprofesor"))
									//genera el acces token
			.authorizedGrantTypes("password","authorization_code","refresh_token","implicit")
			.scopes("read","write","trust")//se va a leer escribir el token 
			.accessTokenValiditySeconds(1*60*60)//tiempo de vida del token
			.refreshTokenValiditySeconds(5*60*60);//tiempo de vida del refresh token
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.tokenStore(store)
			.authenticationManager(manager);
	}

	
}
