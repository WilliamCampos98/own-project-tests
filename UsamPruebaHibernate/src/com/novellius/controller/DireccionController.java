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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Administrador;
import com.novellius.pojo.Direccion;
import com.novellius.service.AdminService;
import com.novellius.service.DireccionService;

@Controller
@SessionAttributes("admin")
public class DireccionController {
	private List<Administrador> listAdmis;
	private Administrador admin;
	private List<Direccion> listDireccions;
	private Direccion direccion;
	@Autowired
	private AdminService adminService;

	@Autowired
	private DireccionService direccionService;

	@RequestMapping("/direccion/{idAd}")
	public String getAll(Model model, @PathVariable("idAd") int idAd) {

		admin = adminService.findByid(idAd);
		model.addAttribute("admin", admin);
		model.addAttribute("idAdmin", admin.getIdAd());
		model.addAttribute("direccion", new Direccion());

		return "direccion";
	}

	@RequestMapping(value = "/showAllDireccions")
	public String findAllDireccions(Model model, @ModelAttribute("resultado") String resultado) {
		listDireccions = new ArrayList<Direccion>();
		listDireccions = direccionService.findAllDireccions();
		System.out.println(listDireccions.size());
		model.addAttribute("listDireccions", listDireccions);
		model.addAttribute("resultado", resultado);
		return "showDireccions";
	}

	@RequestMapping(value = "/direccion/save", method = RequestMethod.POST)
	public String saveDireccion(Model model, @ModelAttribute("direccion") Direccion direccion,
			@ModelAttribute("admin") Administrador admin, RedirectAttributes ra) {
		direccion.setIdAd(admin);
		direccion = direccionService.saveDireccion(direccion);
		model.addAttribute("direccion", direccion);
		ra.addFlashAttribute("resultado", "Dirección guardada con exito");
		return "redirect:/showAllDireccions";
	}

	@RequestMapping(value = "/deleteDireccion/{idDir}/delete")
	public String deleteDireccion(Model model, @PathVariable("idDir") int idDir, RedirectAttributes ra) {
		direccionService.deleteDireccion(idDir);
		ra.addFlashAttribute("resultado", "Exito al eliminar la direccion");
		return "redirect:/showAllDireccions";
	}
	
	@RequestMapping(value = "/updateDireccion/{idDir}/update")
	public String updateDireccion(Model model,@PathVariable("idDir")int idDir,RedirectAttributes ra) {
		direccion = direccionService.findByIdDireccion(idDir);
		listAdmis = adminService.findAll();
		model.addAttribute("idAd", direccion.getIdAd().getIdAd());
		model.addAttribute("listAdmis", listAdmis);
		model.addAttribute("direccion",direccion);
		return "direccionUpdate";
	}
}
