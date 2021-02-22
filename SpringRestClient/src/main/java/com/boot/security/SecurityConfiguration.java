package com.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Zona de beans con configuraciones de spring security le heredo la clase de configuraciones
//aqui asignaremos usuarios desde base de datos y roles para permisos
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	// Usuarios desde base de datos
	@Autowired
	private UserDetailsConfig userConfig;
	// codificador
	@Autowired
	private BCryptPasswordEncoder encoder;

	// codificador de spring security lo declaro como bean en el contenedor de
	// spring
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	// usuarios desde base de datos y codificador
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userConfig).passwordEncoder(encoder);
	}

	/*
	 * Aqui asemos una configuracion similar a la de resourcesServer pero aqui no
	 * definimos los endPoints eso lo trabajremos del lado de spring oauth2
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
				/*
				 * desabilitamos el Cross-site request forgery es una seguridad extra contra
				 * ataques en los formularios pero trabajaremos la api del lado de angular asi
				 * que no sera necesario y desabilitamos las sessiones del lado de spring
				 * security debido a que trabajaremos en base a tokens y no con sessiones como
				 * lo es en spring mvc con sessiones
				 */
				.and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	/*
	 * creo el bean de authentication manager para autentificar las peticiones http
	 * por medio de usaurio y password aun que tambien se requiere autorizacion de
	 * la client Api
	 */
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	/* pruebas de configuraciones de permisos http fallidas */

	// // configuraciones de peticiones http
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// // // cada peticion debe estar autenticada por usuario
	// // // falta agregar token
	// ////
	// http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();
	// http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
	// // permitimos el acceso a /login a
	// // cualquiera
	// .anyRequest().authenticated() // cualquier otra peticion requiere
	// // autenticacion
	// .and()
	// // Las peticiones /login pasaran previamente por este filtro
	// .addFilterBefore(new LoginFilter("/login", authenticationManager()),
	// UsernamePasswordAuthenticationFilter.class)
	// // // Las demás peticiones pasarán por este filtro para validar el token
	// .addFilterBefore(new JwtFilter(),
	// UsernamePasswordAuthenticationFilter.class);
	// }

}
