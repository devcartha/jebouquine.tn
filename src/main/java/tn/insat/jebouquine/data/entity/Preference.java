package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "preferences")
public class Preference {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @OneToOne
	private Client client;
	@ManyToMany
	private List<Editeur> editeurs;
	@ManyToMany
	private List<Auteur> auteurs;
	@ManyToMany
	private List<Categorie> categories;

    public Preference() {
    }

    public Preference(Client client, List<Editeur> editeurs, List<Auteur> auteurs, List<Categorie> categories) {
        this.client = client;
        this.editeurs = editeurs;
        this.auteurs = auteurs;
        this.categories = categories;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Editeur> getEditeurs() {
		return editeurs;
	}

	public void setEditeurs(List<Editeur> editeurs) {
		this.editeurs = editeurs;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Preference that = (Preference) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (editeurs != null ? !editeurs.equals(that.editeurs) : that.editeurs != null) return false;
        if (auteurs != null ? !auteurs.equals(that.auteurs) : that.auteurs != null) return false;
        return !(categories != null ? !categories.equals(that.categories) : that.categories != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (editeurs != null ? editeurs.hashCode() : 0);
        result = 31 * result + (auteurs != null ? auteurs.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Preference{" +
                "id=" + id +
                ", client=" + client +
                ", editeurs=" + editeurs +
                ", auteurs=" + auteurs +
                ", categories=" + categories +
                '}';
    }
}
