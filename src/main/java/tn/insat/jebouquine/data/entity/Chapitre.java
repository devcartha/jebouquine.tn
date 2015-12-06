package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "chapitres")
public class Chapitre {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String extrait;
    @ManyToOne
    private Ouvrage ouvrage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExtrait() {
		return extrait;
	}

	public void setExtrait(String extrait) {
		this.extrait = extrait;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Chapitre chapitre = (Chapitre) o;

		if (id != chapitre.id) return false;
		if (nom != null ? !nom.equals(chapitre.nom) : chapitre.nom != null) return false;
		return !(extrait != null ? !extrait.equals(chapitre.extrait) : chapitre.extrait != null);

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (nom != null ? nom.hashCode() : 0);
		result = 31 * result + (extrait != null ? extrait.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Chapitre{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", extrait='" + extrait + '\'' +
				'}';
	}
}
