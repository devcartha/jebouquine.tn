package tn.insat.jebouquine.presentation.model;

import javax.validation.constraints.Size;

/**
 * Created by Devcartha on 12/10/2015.
 */
public class OuvrageModel {

    @Size(min=5, max=20)
    private String titre;
    private String isbn;
    private String dateParution;
    //url
    private String image;
    private int quantiteDispo;
    //url
    private String tableDeMatiere;
    private String categories;
    private String auteurs;
    private String editeur;

    public OuvrageModel() {
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

    public int getQuantiteDispo() {
        return quantiteDispo;
    }

    public void setQuantiteDispo(int quantiteDispo) {
        this.quantiteDispo = quantiteDispo;
    }

    public String getTableDeMatiere() {
        return tableDeMatiere;
    }

    public void setTableDeMatiere(String tableDeMatiere) {
        this.tableDeMatiere = tableDeMatiere;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(String auteurs) {
        this.auteurs = auteurs;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
}
