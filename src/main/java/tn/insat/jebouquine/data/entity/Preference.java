package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "preferences")
public class Preference {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    @OneToOne
	private Client client;
	@ManyToMany
	private Collection<Editeur> editeurs;
	@ManyToMany
	private Collection<Auteur> auteurs;
	@ManyToMany
	private Collection<Categorie> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Editeur> getEditeurs() {
		return editeurs;
	}

	public void setEditeurs(Collection<Editeur> editeurs) {
		this.editeurs = editeurs;
	}

	public Collection<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Preference that = (Preference) o;

        if (id != that.id) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (editeurs != null ? !editeurs.equals(that.editeurs) : that.editeurs != null) return false;
        if (auteurs != null ? !auteurs.equals(that.auteurs) : that.auteurs != null) return false;
        return !(categories != null ? !categories.equals(that.categories) : that.categories != null);

    }

    @Override
    public int hashCode() {
        int result = id;
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
