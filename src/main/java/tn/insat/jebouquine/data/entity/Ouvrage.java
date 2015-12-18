package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ouvrages")
public class Ouvrage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String isbn;
    private String dateParution;
    //url image
    @Lob
    private String image;
    //url fichier pdf
    @Lob
    private String tableDeMatiere;
    private int quantiteDispo;
    private int quantiteVendus;
    private double prix;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Categorie> categories;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Auteur> auteurs;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "editeur_id")
    private Editeur editeur;

    public Ouvrage() {
        this.categories = new ArrayList<>();
        this.auteurs = new ArrayList<>();
        this.editeur = new Editeur();
    }

    public Ouvrage(String titre, String isbn, String dateParution, String image, String tableDeMatiere, int quantiteDispo, int quantiteVendus, double prix) {
        this.titre = titre;
        this.isbn = isbn;
        this.dateParution = dateParution;
        this.image = image;
        this.tableDeMatiere = tableDeMatiere;
        this.quantiteDispo = quantiteDispo;
        this.quantiteVendus = quantiteVendus;
        this.prix = prix;
        this.categories = new ArrayList<>();
        this.auteurs = new ArrayList<>();
        this.editeur = new Editeur();
    }

    public Ouvrage(String titre, String isbn, String dateParution, String image, String tableDeMatiere, int quantiteDispo, int quantiteVendus, double prix, List<Categorie> categories, List<Auteur> auteurs, Editeur editeur) {
        this.titre = titre;
        this.isbn = isbn;
        this.dateParution = dateParution;
        this.image = image;
        this.tableDeMatiere = tableDeMatiere;
        this.quantiteDispo = quantiteDispo;
        this.quantiteVendus = quantiteVendus;
        this.prix = prix;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getTableDeMatiere() {
        return tableDeMatiere;
    }

    public void setTableDeMatiere(String tableDeMatiere) {
        this.tableDeMatiere = tableDeMatiere;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<Auteur> auteurs) {
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
        Ouvrage that = (Ouvrage) o;
        return (this.getIsbn().equals(that.getIsbn()));
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
                ", categories=" + categories +
                ", auteurs=" + auteurs +
                ", editeur=" + editeur +
                '}';
    }

    public String getAuteursAsText() {
        String auteursText = "";
        if (auteurs != null && !auteurs.isEmpty()) {
            for (Auteur a : auteurs)
                auteursText += a.getNom() + ",";
            auteursText = auteursText.substring(0, auteursText.lastIndexOf(","));
        }
        return auteursText;
    }

    public String getCategoriesAsText() {
        String categoriesText = "";
        if (categories != null && !categories.isEmpty()) {
            for (Categorie c : categories)
                categoriesText += c.getTitre() + ",";
            categoriesText = categoriesText.substring(0, categoriesText.lastIndexOf(","));
        }
        return categoriesText;
    }

    public String getEditeurAsText() {
        String editeurText = "";
        if (editeur != null)
            editeurText = editeur.getNom();
        return editeurText;
    }

    public String getImageAsText() {
        if (image != null && image.contains("|"))
            return image.substring(image.indexOf("|") + 1);
        return image;
    }

    public String getTableDeMatiereAsText() {
        if (tableDeMatiere != null && tableDeMatiere.contains("|"))
            return tableDeMatiere.substring(tableDeMatiere.indexOf("|") + 1);
        return tableDeMatiere;
    }
}
