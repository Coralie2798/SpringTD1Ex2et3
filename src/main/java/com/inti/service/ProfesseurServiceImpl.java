package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;


import com.inti.model.Professeur;
import com.inti.util.HibernateUtil;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	
	
	@Override
	public List<Professeur> getProfesseurs() {
		List<Professeur>listeP=null;
		try {
			EtudiantServiceImpl.s.beginTransaction();
			
			listeP= EtudiantServiceImpl.s.createNativeQuery("select * from professeur",Professeur.class).list();
			
			
			EtudiantServiceImpl.s.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				EtudiantServiceImpl.s.getTransaction().rollback();
			}
			return listeP;
		}


	@Override
	public void saveProfesseur(Professeur p) {
		try {
			EtudiantServiceImpl.s.beginTransaction();
			
			EtudiantServiceImpl.s.save(p);
			
			EtudiantServiceImpl.s.getTransaction().commit();
			}catch (Exception ex) {
				ex.printStackTrace();
				EtudiantServiceImpl.s.getTransaction().rollback();
			}
	}

	@Override
	public Professeur getProfesseur(int id) {
		Professeur prof=null;
		try {
			EtudiantServiceImpl.s.beginTransaction();
			
			prof=EtudiantServiceImpl.s.get(Professeur.class, id);
			
			EtudiantServiceImpl.s.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				EtudiantServiceImpl.s.getTransaction().rollback();
			}
			return prof;
	
	}

	@Override
	public Professeur deleteProfesseur(int id) {
		try {
			EtudiantServiceImpl.s.beginTransaction();
			
			EtudiantServiceImpl.s.delete(EtudiantServiceImpl.s.get(Professeur.class, id));
			
			EtudiantServiceImpl.s.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				EtudiantServiceImpl.s.getTransaction().rollback();
			}
		return null;
	}

}
