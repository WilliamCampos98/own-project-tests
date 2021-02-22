package com.boot.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager auth;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private InfoAditionalToken infoAditional;
	/* clave secreta de cifrado */
	public static final String claveSecreta = "prueba.clave.secreta.i-strategies";

	/* validacion de un token */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		/*
		 * por el metodo permitAll() permitimos que cualquier usuario pueda validar sus
		 * credenciales
		 */
		/*
		 * el segundo metodo es para poder validar el token aqui solo pueden entrar
		 * usuarios validados
		 */
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	/*
	 * configuramos un cliente para consumir nuestra api rest seria una doble
	 * verificacion aqui designamos la duracion del token y si fuese refrescado
	 * tambein poseeria un tiempo limite de vida antes de volver a logearse
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("apiClient").secret(encoder.encode("12345")).scopes("read", "write")
				// designo el tiempo de vida del token en segundos
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(3600)
				.refreshTokenValiditySeconds(3600);
	}

	// authorization manager valida las autorizaciones a los endPoints con su metodo
	// de token access y token converter
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// Aqui agregamos una cadena de informacion adicional al token esto puede traer
		// infomacion basica
		// o sensible se recomienda solo informacion basica puesto que con javaScript se
		// puede
		// decodificar
		TokenEnhancerChain tokenEnhancer = new TokenEnhancerChain();
		tokenEnhancer.setTokenEnhancers(Arrays.asList(infoAditional, accessTokenConverter()));
		endpoints.authenticationManager(auth).tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter())
				.tokenEnhancer(tokenEnhancer);
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	// aqui validamos el token para ver si no ha sido alterado por medio de una
	// clave secreta
	// estos token poseen un header donde describe la forma en que esta crifrado,
	// un payload donde viene la informacion del usuario enbase64 y una firma
	// que consta de union de los primeros dos segmentos y una clave secreta
	// si se mdoficara algun caracter ya no seria igual con la clave y se
	// invalidaria
	// el token
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtConverter = new JwtAccessTokenConverter();
		jwtConverter.setSigningKey(claveSecreta);
		return jwtConverter;
	}
}
