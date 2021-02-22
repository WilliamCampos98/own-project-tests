package com.novellius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*el dispatcher se encargar de recibir todas las peticiones http en spring, un handler mapping detecta
 * la peticion la envia al dispatcher y este buscara un controlador spring con la anotacion @Controller
 * y buscara un controlador para la peticion el controlador returnara un nombre logico de la vista
 * de vuelta a distpatcher y la enviara a un viewResolver que le dara un prefijo y sufijo y se renderiza la vista
 * 
 *  con el nombre log anotacion controller recibira las peticiones desde el dispatcher
 *  y las enviara a surespectivo controalador
 */
@Controller
/*
 * anotacion sessionAtributes aceptara una lista de atributos desde el modelo
 * este mantendra los atributos en session en todas las paginas para el usuario
 * en httpSession
 */
@SessionAttributes("mensaje")
public class IndexController {
	@RequestMapping("/")
	public String mostrarIndex(Model model) {
		model.addAttribute("modelo", "Soy una persona");
		model.addAttribute("mensaje", "Hola mundo desde controlador");
		return "index";
	}

	@RequestMapping(value = "/persona")
	public String personaInformacion(Model model, @RequestParam("nombre") String nombre) {
		/* anotacion @RequestParam sirve para capturar un parametro en html convencional
		 * lo agrego al modelo y lo imprimo los atributos agregados en el modelo desde
		 * el controlador solo seran visibles para ese controlador
		 */
		model.addAttribute("nombre", "Hola buenos dias: " + nombre);
		return "persona";
	}

	@RequestMapping("/humano")
	public String humanoInformacion(SessionStatus session, Model modelo) {
		/* este metodo borra los atributos de session */
		session.setComplete();
		modelo.addAttribute("humano", "Soy un buen humano");
		return "humano";
	}
}
