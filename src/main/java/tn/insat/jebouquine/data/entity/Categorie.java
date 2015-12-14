package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Categorie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;

	public Categorie() {
	}

	public Categorie(String titre) {
		this.titre = titre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Categorie categorie = (Categorie) o;

		if (id != categorie.id) return false;
		return !(titre != null ? !titre.equals(categorie.titre) : categorie.titre != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (titre != null ? titre.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "categorie{" +
				"id=" + id +
				", titre='" + titre + '\'' +
				'}';
	}
}
