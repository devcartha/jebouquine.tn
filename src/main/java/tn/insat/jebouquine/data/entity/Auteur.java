package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Auteurs")
public class Auteur {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private String nationalite;
	private String email;

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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Auteur auteur = (Auteur) o;

		if (id != auteur.id) return false;
		if (nom != null ? !nom.equals(auteur.nom) : auteur.nom != null) return false;
		if (prenom != null ? !prenom.equals(auteur.prenom) : auteur.prenom != null) return false;
		if (nationalite != null ? !nationalite.equals(auteur.nationalite) : auteur.nationalite != null) return false;
		return !(email != null ? !email.equals(auteur.email) : auteur.email != null);

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (nom != null ? nom.hashCode() : 0);
		result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
		result = 31 * result + (nationalite != null ? nationalite.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Auteur{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", nationalite='" + nationalite + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
