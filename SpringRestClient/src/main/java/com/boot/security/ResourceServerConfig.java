package com.boot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/*por medio de esta clase configuramos los accesos a los endPoints de los recrusos del servidor*/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/* en un inicio declare cada endPoint aqui pero se puede pasar a anotaciones */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		/*
		 * en la configuracion actual podemos acceder a todas los endPoints con estar
		 * logueados otros con tener rango admin y otros son de libre acceso
		 */
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/studentApi/all", "/studentApi/allStudents").permitAll()
				// .antMatchers(HttpMethod.GET, "/studentApi/allSubjects").hasAnyRole("ADMIN",
				// "USER")
				// .antMatchers(HttpMethod.GET, "/studentApi/find/{id}").hasAnyRole("ADMIN",
				// "USER")
				// .antMatchers(HttpMethod.DELETE, "/studentApi/delete/{id}").hasRole("ADMIN")
				// .antMatchers(HttpMethod.POST, "/studentApi/save").hasRole("ADMIN")
				// .antMatchers(HttpMethod.PUT, "/studentApi/update").hasRole("ADMIN")
				.anyRequest().authenticated();
	}
}
