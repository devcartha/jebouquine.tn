package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ouvrages")
public class Ouvrage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String titre;
	private String ISBN;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getDateParution() {
		return dateParution;
	}

	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
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

}
