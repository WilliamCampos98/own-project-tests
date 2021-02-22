package com.novellius.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Administrador;
import com.novellius.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	private List<Administrador> listAdmins;
	private Administrador admin;

	@RequestMapping("/admin")
	public String showAdmin(@ModelAttribute("resultado") String resultado, Model model) {
		listAdmins = new ArrayList<Administrador>();
		admin = new Administrador();
		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);
		return "admin";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Administrador adminForm, Model model, RedirectAttributes ra) {
		/*
		 * la @ModelAttribute nos permite leer un atributo del modelo con una clase en
		 * la anotacion @RequestParam te permite leer un atributo convencional de html,
		 * " @RequestParam("estado")String estado" este caso admin
		 */
		service.save(adminForm);
		ra.addFlashAttribute("resultado", "Cambios realizados con exito!");

		System.out.println("Resultado de vista! " + adminForm);

		return "redirect:/admin";
	}

	@RequestMapping(value = "/showAdmins")
	public String showAdmins(Model model, @ModelAttribute("resultado") String resultado) {
		listAdmins = new ArrayList<Administrador>();
		listAdmins = service.findAll();
		model.addAttribute("resultado", resultado);
		model.addAttribute("listAdmins", listAdmins);
		return "showAdmins";
	}

	@RequestMapping(value = "/updateAdmin/{idAd}/update")
	public String findAdmin(@PathVariable("idAd") int id, Model model) {
		admin = service.findByid(id);
		model.addAttribute("adminUpdate", admin);
		return "updateAdmin";
	}

	@RequestMapping(value = "/updateAdmin/update", method = RequestMethod.POST)
	public String updateAdmin(@ModelAttribute("adminUpdate") Administrador adminUpdate, RedirectAttributes ra) {

		admin = service.update(adminUpdate);
		ra.addAttribute("resultado", "Exito de actualizacion!");
		return "redirect:/admin";
	}

	@RequestMapping("deleteAdmin/{idAd}/delete")
	public String deleteAdmin(@PathVariable("idAd") int idAd, RedirectAttributes ra) {
		service.delete(idAd);
		ra.addFlashAttribute("resultado", "Exito al eliminar!");

		return "redirect:/showAdmins";
	}

}
