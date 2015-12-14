package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Avis")
public class Avi {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String commentaire;
	@ManyToOne
    @JoinColumn(name = "client_id")
	private Client client;
	@ManyToOne
    @JoinColumn(name = "ouvrage_id")
	private Ouvrage ouvrage;

    public Avi() {
    }

    public Avi(String avi, Client client, Ouvrage ouvrage) {
        this.commentaire = avi;
        this.client = client;
        this.ouvrage = ouvrage;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String avi) {
		this.commentaire = avi;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

		Avi avi1 = (Avi) o;

		if (id != null ? !id.equals(avi1.id) : avi1.id != null) return false;
		if (commentaire != null ? !commentaire.equals(avi1.commentaire) : avi1.commentaire != null) return false;
		if (client != null ? !client.equals(avi1.client) : avi1.client != null) return false;
		return !(ouvrage != null ? !ouvrage.equals(avi1.ouvrage) : avi1.ouvrage != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
		result = 31 * result + (client != null ? client.hashCode() : 0);
		result = 31 * result + (ouvrage != null ? ouvrage.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Avi{" +
				"id=" + id +
				", commentaire='" + commentaire + '\'' +
				", client=" + client +
				", ouvrage=" + ouvrage +
				'}';
	}
}

