package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Auteurs")
public class Auteur {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String nationalite;
	private String email;

    public Auteur() {
    }

    public Auteur(String nom, String nationalite, String email) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.email = email;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		if (nationalite != null ? !nationalite.equals(auteur.nationalite) : auteur.nationalite != null) return false;
		return !(email != null ? !email.equals(auteur.email) : auteur.email != null);

	}

	@Override
	public int hashCode() {

		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (nom != null ? nom.hashCode() : 0);
		result = 31 * result + (nationalite != null ? nationalite.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Auteur{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", nationalite='" + nationalite + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
