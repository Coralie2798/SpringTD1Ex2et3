package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.inti.model.Etudiant;
import com.inti.util.HibernateUtil;

@Service
public class EtudiantServiceImpl implements EtudiantService{

	private static Session s=HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public List<Etudiant> getEtudiants() {
		List<Etudiant>listeE=null;
		try {
		s.beginTransaction();
		
		listeE= s.createNativeQuery("select * from etudiant",Etudiant.class).list();
		
		
		s.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return listeE;
	}

	@Override
	public void saveEtudiant(Etudiant e) {
		try {
		s.beginTransaction();
		
		s.save(e);
		
		s.getTransaction().commit();
		}catch (Exception ex) {
			ex.printStackTrace();
			s.getTransaction().rollback();
		}
		
	}

	@Override
	public Etudiant getEtudiant(int id) {
		Etudiant etu=null;
		try {
		s.beginTransaction();
		
		etu=s.get(Etudiant.class, id);
		
		s.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return etu;
	}

	@Override
	public Etudiant deleteEtudiant(int id) {
		
		try {
			s.beginTransaction();
			
			s.delete(s.get(Etudiant.class, id));
			
			s.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				s.getTransaction().rollback();
			}
		return null;
	}

}
