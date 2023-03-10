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
public class Professeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private double salaire;
	
	@ManyToMany
	@JoinTable(name="professeur_etudiant", joinColumns = @JoinColumn(name="idProf"),inverseJoinColumns = @JoinColumn(name="idEtu"))
	List<Etudiant>listeEtu;
	
	public Professeur() {
		super();
	}

	public Professeur(String nom, String prenom, double salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
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

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

//	public List<Etudiant> getListeEtu() {
//		return listeEtu;
//	}
//
//	public void setListeEtu(List<Etudiant> listeEtu) {
//		this.listeEtu = listeEtu;
//	}

	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + "]";
	}
	
	
}
