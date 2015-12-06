package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Avis")
public class Avi {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int note;
	@ManyToOne
    @JoinColumn(name = "client_id")
	private Client client;
	@ManyToOne
    @JoinColumn(name = "ouvrage_id")
	private Ouvrage ouvrage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
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

        Avi avi = (Avi) o;

        if (id != avi.id) return false;
        if (note != avi.note) return false;
        if (client != null ? !client.equals(avi.client) : avi.client != null) return false;
        return !(ouvrage != null ? !ouvrage.equals(avi.ouvrage) : avi.ouvrage != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + note;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (ouvrage != null ? ouvrage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Avi{" +
                "id=" + id +
                ", note=" + note +
                ", client=" + client +
                ", ouvrage=" + ouvrage +
                '}';
    }
}
