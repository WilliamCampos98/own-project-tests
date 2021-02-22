package com.boot;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.entities.Role;
import com.boot.entities.Student;
import com.boot.entities.Users;
import com.boot.service.StudentService;
import com.boot.service.UserService;

//zona de pruebas de spring test
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRestClientApplicationTests {
	// Codificador
	@Autowired
	private BCryptPasswordEncoder enconder;
	@Autowired
	private StudentService estudentService;
	@Autowired
	private UserService userService;

	// Instancia de Estudiante y usuario con codificador de password para
	// posteriomente
	// Persistirlos en base de datos con sus metodos save de service
	@Test
	public void save() {
		Student student = new Student(null, "453566", "Marvin", "Ernesto", "Barahona", "Martinez", new Date());
		Student stu = estudentService.save(student);

		Users us = new Users(null, "MarvinOwO", enconder.encode("12345"), true, null, null, null, new Role(1));
		Users user = userService.saveUsuario(us);

		// pruebas de jUnit compruebo si los parametros que envio son iguales a los que
		// se almacenan en la base
		assertTrue(us.getPass().equalsIgnoreCase(user.getPass()));
		assertTrue(stu.getFirstName().equalsIgnoreCase(student.getFirstName()));
	}
}
