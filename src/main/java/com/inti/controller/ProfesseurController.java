package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Professeur;
import com.inti.service.ProfesseurService;

@Controller
@RequestMapping("professeur")
public class ProfesseurController {

	@Autowired
	ProfesseurService ps;

	@GetMapping("inscriptionP")
	public String inscriptionProfesseur()
	{
		return "inscriptionP";
	}
	
	@PostMapping("saveProfAvecForm")
	public String enregistrerEtu(@ModelAttribute("prof") Professeur p, Model m)
	{
		ps.saveProfesseur(p);
		m.addAttribute("p", p);
		return "enregistrerP";
	}
	

	@GetMapping("listeEtu")
	public String getAllProfesseurs(Model m){
		
		m.addAttribute("listeP",ps.getProfesseurs());
		return "listeProfesseurs";
	}
	
	@GetMapping("prof")
	public String getProfesseur(@RequestParam("id")int id, Model m) {
		
		m.addAttribute("p",ps.getProfesseur(id));
		return "professeur";
	}
	
	@GetMapping("supprimerP")
	public  String delete(@RequestParam("id")int id, Model m) {
		
		m.addAttribute("p",ps.deleteProfesseur(id));
		return "supprimerP";
	}
}
