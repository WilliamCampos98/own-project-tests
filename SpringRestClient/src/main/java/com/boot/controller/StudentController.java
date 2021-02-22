package com.boot.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entities.Note;
import com.boot.entities.Student;
import com.boot.entities.Subject;
import com.boot.models.NoteM;
import com.boot.models.ResponseObject;
import com.boot.models.StudentM;
import com.boot.repo.SubjectRepo;
import com.boot.service.StudentService;

//mi api rest con su path
/*Acceder a la autenticacion de la api...
 * en la path auth/token en body con x-www-form-urlencoded acceder con username, password y grant_type
 * con valor de passsword y en el header de igual manera con username de apiClient, password de valor 12345
 * te devolvera un token usarlo y mandarlo en los headers para las demas peticiones de tipo Authorization de value
 *  Bearer "my token"
 */
@RestController
@RequestMapping("/studentApi")
public class StudentController {
	// variables para su uso en metodos
	private Student students;
	private List<Student> listStudents;
	// mi modelo de respuesta aqui agrego informacion y anexo mi objeto
	private ResponseObject response;
	// servicio del estudiante
	@Autowired
	private StudentService service;
	@Autowired
	private SubjectRepo subRepo;
	// lista de las entidades clones para no mandar las rpopia y evitar
	// errores como siclos infinitos
	private List<Subject> listSubjects;
	private List<NoteM> listsNotesM;
	private List<StudentM> listStudentM;

	// metodo para encontrar todos los registros de estudiantes en el sistema
	// produce application jSon con validaciones y en todo caso envia el response
	// entity
	// con una entidad y respuesta
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> find(Pageable pageable) {
		try {
			listStudentM = new ArrayList<>();
			listsNotesM = new ArrayList<>();
			listStudents = service.findAll(pageable);
			StudentM studentM;
			// inicializo
			if (listStudents.size() > 0) {
				// si la lista esta llena la anexa y envia mensaje de exito con un ok de http
				// status
				// Dentro del for inicializo una entidad clon con los valores
				// de la entidad real
				for (Student e : listStudents) {
					studentM = new StudentM(e);
					NoteM noteM;
					studentM.setNoteList(null);
					if (e.getNoteList().size() > 0) {
						for (Note n : e.getNoteList()) {
							noteM = new NoteM(n);
							listsNotesM.add(noteM);
						}
						studentM.setNoteList(listsNotesM);
					}
					listStudentM.add(studentM);
					listsNotesM = new ArrayList<>();
				}
				response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Lista Cargada!",
						"studentApi/all", listStudentM);
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			} else {
				// sino esta llena envia que esta vacia y envia un bad request como respuesta
				response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
						"La lista esta vacia!", "studentApi/all", null);
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// en caso de cualquier error envia error, fecha y deja vacia la lista
			response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Ocurrio un error!",
					"studentApi/all", null);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// rest basico de pruebas para ver los subjects almacenados
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping(value = "/allSubjects", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Subject> findAllSubjects() {
		listSubjects = new ArrayList<Subject>();
		listSubjects = subRepo.findAll();
		return listSubjects;
	}

	// modifique el metodo para aceptar paginacion y tamano del registro
	// puedes pedir parametros de ?page=numero de pagina empieza en cero &
	// size=tamano del
	// valor del valor de la consulta
	@GetMapping(value = "/allStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentM> findAllStudents(Pageable pageable) {
		listStudentM = new ArrayList<>();
		listsNotesM = new ArrayList<>();
		listStudents = service.findAll(pageable);
		StudentM studentM;
		for (Student e : listStudents) {
			studentM = new StudentM(e);
			NoteM noteM;
			studentM.setNoteList(null);
			if (e.getNoteList().size() > 0) {
				System.out.println("Entre aqui y es de: " + e.getNoteList().size());
				for (Note n : e.getNoteList()) {
					noteM = new NoteM(n);
					listsNotesM.add(noteM);
				}
				studentM.setNoteList(listsNotesM);
				listsNotesM = new ArrayList<>();
			}
			listStudentM.add(studentM);
		}
		return listStudentM;
	}

	// metodo para encontrar por un id un estudiante capturo el id y consulto un
	// estudiante en base a ese id
	// este metodo cuenta con el mismo tipo de validaciones que hago en el metodo de
	// all
	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
		StudentM studentM = new StudentM();
		NoteM noteM = new NoteM();
		listsNotesM = new ArrayList<>();
		// paso los valores de la entidad real a la clon
		try {
			students = service.findById(id);
			if (students != null) {
				studentM = new StudentM(students);
				for (Note n : students.getNoteList()) {
					noteM = new NoteM(n);
					listsNotesM.add(noteM);
				}
				studentM.setNoteList(listsNotesM);
				response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Exito!",
						"studentApi/find/" + id, studentM);
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			} else {
				response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
						"No se encontro el requistro!", "studentApi/find/" + id, null);
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Ocurrio un error!",
					"studentApi/find/" + id, null);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// metodo para borrar por id pero en este caso debo modificarlo para que solo
	// cambie el estado y
	// en el metodo de all descartar los que tegan el estado en false
	// validaciones estandares
	@Secured("ROLE_ADMIN")
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		Boolean respuesta = false;
		try {
			respuesta = service.delete(id);
			if (respuesta == true) {
				response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Exito!",
						"studentApi/delete/" + id, respuesta);
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			} else {
				response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
						"No se encontro el requistro!", "studentApi/delete/" + id, respuesta);
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Ocurrio un error!",
					"studentApi/delete/" + id, respuesta);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// metodo save recive una entidad studiante y lo persistira con todas sus tablas
	// relacionadas
	// posee validaciones estandares
	@Secured("ROLE_ADMIN")
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody Student student) {
		try {
			students = service.save(student);
			response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Exito!",
					"studentApi/save", students);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Ocurrio un error!",
					"studentApi/save", null);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// metodo de update consiste en los mismo que save de hecho aplico el mismo
	// metodo del service
	// lo unico que estara actuara diferente debido a que posee un id solo
	// modificara
	// posee validaciones estandares
	@Secured("ROLE_ADMIN")
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody Student student) {
		try {
			students = service.save(student);
			response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Exito!",
					"studentApi/update", students);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Ocurrio un error!",
					"studentApi/update", null);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
