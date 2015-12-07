package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "ouvrages")
public class Ouvrage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;
	private String isbn;
	private String dateParution;
	private String image;
	private int quantiteDispo;
	private int quantiteVendus;
	@OneToMany(mappedBy = "ouvrage")
	private Collection<Chapitre> chapitres;
	@ManyToMany
	private Collection<Categorie> categories;
	@ManyToMany
	private Collection<Auteur> auteurs;
	@ManyToOne
	@JoinColumn(name = "editeur_id")
	private Editeur editeur;

	public Ouvrage() {
	}

	public Ouvrage(String titre, String ISBN, Date dateParution, String image, int quantiteDispo, int quantiteVendus, Collection<Chapitre> chapitres, Collection<Categorie> categories, Collection<Auteur> auteurs, Editeur editeur) {
		this.titre = titre;
		this.isbn = ISBN;
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        this.dateParution = formater.format(dateParution);
		this.image = image;
		this.quantiteDispo = quantiteDispo;
		this.quantiteVendus = quantiteVendus;
		this.chapitres = chapitres;
		this.categories = categories;
		this.auteurs = auteurs;
		this.editeur = editeur;
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

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String iSBN) {
        isbn = iSBN;
	}

	public String getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
		this.dateParution = formater.format(dateParution);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantiteDispo() {
		return quantiteDispo;
	}

	public void setQuantiteDispo(int quantiteDispo) {
		this.quantiteDispo = quantiteDispo;
	}

	public int getQuantiteVendus() {
		return quantiteVendus;
	}

	public void setQuantiteVendus(int quantiteVendus) {
		this.quantiteVendus = quantiteVendus;
	}

	public Collection<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(Collection<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}

	public Collection<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Ouvrage ouvrage = (Ouvrage) o;

		if (quantiteDispo != ouvrage.quantiteDispo) return false;
		if (quantiteVendus != ouvrage.quantiteVendus) return false;
		if (id != null ? !id.equals(ouvrage.id) : ouvrage.id != null) return false;
		if (titre != null ? !titre.equals(ouvrage.titre) : ouvrage.titre != null) return false;
		if (isbn != null ? !isbn.equals(ouvrage.isbn) : ouvrage.isbn != null) return false;
		if (dateParution != null ? !dateParution.equals(ouvrage.dateParution) : ouvrage.dateParution != null)
			return false;
		if (image != null ? !image.equals(ouvrage.image) : ouvrage.image != null) return false;
		if (chapitres != null ? !chapitres.equals(ouvrage.chapitres) : ouvrage.chapitres != null) return false;
		if (categories != null ? !categories.equals(ouvrage.categories) : ouvrage.categories != null) return false;
		if (auteurs != null ? !auteurs.equals(ouvrage.auteurs) : ouvrage.auteurs != null) return false;
		return !(editeur != null ? !editeur.equals(ouvrage.editeur) : ouvrage.editeur != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (titre != null ? titre.hashCode() : 0);
		result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
		result = 31 * result + (dateParution != null ? dateParution.hashCode() : 0);
		result = 31 * result + (image != null ? image.hashCode() : 0);
		result = 31 * result + quantiteDispo;
		result = 31 * result + quantiteVendus;
		result = 31 * result + (chapitres != null ? chapitres.hashCode() : 0);
		result = 31 * result + (categories != null ? categories.hashCode() : 0);
		result = 31 * result + (auteurs != null ? auteurs.hashCode() : 0);
		result = 31 * result + (editeur != null ? editeur.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Ouvrage{" +
				"id=" + id +
				", titre='" + titre + '\'' +
				", ISBN='" + isbn + '\'' +
				", dateParution='" + dateParution + '\'' +
				", image='" + image + '\'' +
				", quantiteDispo=" + quantiteDispo +
				", quantiteVendus=" + quantiteVendus +
				", chapitres=" + chapitres +
				", categories=" + categories +
				", auteurs=" + auteurs +
				", editeur=" + editeur +
				'}';
	}
}
