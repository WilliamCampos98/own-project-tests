package com.boot.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entities.Users;
import com.boot.repo.UserRepo;

//Configuracion del service de usuario con interfaz de userDetailSerivce 
//en esta interfaz sobre escribimos el metodo de por defecto en el cual
//pasaremos nuestros usuarios desde base de datos para posteriormente 
//en las configuraciones de spring asignarlos y dar permisos
@Service
public class UserDetailsConfig implements UserDetailsService {
	// repositorio de usuario para consulta
	@Autowired
	private UserRepo repo;

	public static Logger log = LoggerFactory.getLogger(UserDetailsConfig.class);

	// el metodo encuentra los usuarios por username es importante que no exitan
	// usuarios con el username repetido
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			log.info("Validando usuario y contrasena!...");
			// consulto el usuario por rol
			Users us = repo.findByUser(username);
			// inicio la lista de GrantedAuthority de spring security para designar roles
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			// le agrego el rol del usuario
			roles.add(new SimpleGrantedAuthority(us.getIdRole().getRol()));
			// instancio un user details service con los datos de la entidad real y lo
			// retorno para su posterior uso en
			// login de peticiones http
			log.info("Exito! Usuario validado!");

			return new User(us.getUser(), us.getPass(), us.getState(), true, true, true, roles);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Se presento un error, Posible causa... usuario no encontrado");
			throw new UsernameNotFoundException("Se presento un error, Posible causa... usuario no encontrado");
		}

	}
}
