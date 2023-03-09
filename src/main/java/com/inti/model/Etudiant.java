package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String tel;
	private String mail;
	
//	@ManyToMany
//	@JoinTable(name="professeur_etudiant", joinColumns = @JoinColumn(name="idE"),inverseJoinColumns = @JoinColumn(name="idP"))
//	private List<Professeur>listeProf;

	

	public Etudiant() {
		super();
	}

	public Etudiant(String nom, String prenom, String tel, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
//	public List<Professeur> getListeProf() {
//		return listeProf;
//	}
//
//	public void setListeProf(List<Professeur> listeProf) {
//		this.listeProf = listeProf;
//	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", mail=" + mail + "]";
	}
	
	
}
