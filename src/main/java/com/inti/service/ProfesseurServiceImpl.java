package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;


import com.inti.model.Professeur;
import com.inti.util.HibernateUtil;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	private static Session s=HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public List<Professeur> getProfesseurs() {
		List<Professeur>listeP=null;
		try {
			s.beginTransaction();
			
			listeP= s.createNativeQuery("select * from professeur",Professeur.class).list();
			
			
			s.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				s.getTransaction().rollback();
			}
			return listeP;
		}


	@Override
	public void saveProfesseur(Professeur p) {
		try {
			s.beginTransaction();
			
			s.save(p);
			
			s.getTransaction().commit();
			}catch (Exception ex) {
				ex.printStackTrace();
				s.getTransaction().rollback();
			}
	}

	@Override
	public Professeur getProfesseur(int id) {
		Professeur prof=null;
		try {
			s.beginTransaction();
			
			prof=s.get(Professeur.class, id);
			
			s.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				s.getTransaction().rollback();
			}
			return prof;
	
	}

	@Override
	public Professeur deleteProfesseur(int id) {
		try {
			s.beginTransaction();
			
			s.delete(s.get(Professeur.class, id));
			
			s.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				s.getTransaction().rollback();
			}
		return null;
	}

}
