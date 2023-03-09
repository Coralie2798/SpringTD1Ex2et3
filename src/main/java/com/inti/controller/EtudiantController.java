package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Etudiant;
import com.inti.service.EtudiantService;
import com.inti.service.EtudiantServiceImpl;


@Controller
@RequestMapping("etudiant")
public class EtudiantController {
	@Autowired
	EtudiantService es;

	@GetMapping("save")
	public String enregistrerEtudiant(@RequestParam("nom")String nom,@RequestParam("prenom")String prenom,
			@RequestParam("tel")String tel,@RequestParam("mail")String mail,Model m) {
		Etudiant e=new Etudiant(nom,prenom,tel,mail);
//		EtudiantService es=new EtudiantServiceImpl();
		es.saveEtudiant(e);
		
		m.addAttribute("e", e);
		
		return "Enregistrer";
	}
	
	@GetMapping("listeEtu")
	public String getAllEtudiants(Model m){
		
//		EtudiantService es=new EtudiantServiceImpl();
		m.addAttribute("listeE",es.getEtudiants());
		return "listeEtudiant";
	}
	
	@GetMapping("unEtu")
	public String getEtudiant(@RequestParam("id")int id, Model m) {
		
		m.addAttribute("e",es.getEtudiant(id));
		return "etudiant";
	}
	
	@GetMapping("supprimer")
	public  String delete(@RequestParam("id")int id, Model m) {
		
		m.addAttribute("e",es.deleteEtudiant(id));
		return "supprimer";
	}
	
	@GetMapping("inscriptionE")
	public String inscriptionEtudiant()
	{
		return "inscriptionE";
	}
	
	@PostMapping("saveEtuAvecForm")
	public String enregistrerEtu(@ModelAttribute("etu") Etudiant e, Model m)
	{
		es.saveEtudiant(e);
		m.addAttribute("e", e);
		return "Enregistrer";
	}
}
