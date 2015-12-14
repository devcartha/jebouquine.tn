package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name="Editeurs")
public class Editeur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;

	public Editeur() {
	}

	public Editeur(String nom) {
		this.nom = nom;
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

	@Override
	public String toString() {
		return "editeur{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				'}';
	}
}
