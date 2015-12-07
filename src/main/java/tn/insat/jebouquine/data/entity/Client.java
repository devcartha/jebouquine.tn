package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String numeroPasseport;
	private String email;
	private String adresse;
	@OneToOne(mappedBy = "client")
	private Preference preference;

	public Client() {
	}

	public Client(String nom, String prenom, String cin, String numeroPasseport, String email, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.numeroPasseport = numeroPasseport;
		this.email = email;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNumeroPasseport() {
		return numeroPasseport;
	}

	public void setNumeroPasseport(String numeroPasseport) {
		this.numeroPasseport = numeroPasseport;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference prefrence) {
		this.preference = prefrence;
	}


    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (id != client.id) return false;
		if (nom != null ? !nom.equals(client.nom) : client.nom != null) return false;
		if (prenom != null ? !prenom.equals(client.prenom) : client.prenom != null) return false;
		if (cin != null ? !cin.equals(client.cin) : client.cin != null) return false;
		if (numeroPasseport != null ? !numeroPasseport.equals(client.numeroPasseport) : client.numeroPasseport != null)
			return false;
		if (email != null ? !email.equals(client.email) : client.email != null) return false;
		if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;
		return !(preference != null ? !preference.equals(client.preference) : client.preference != null);

	}

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (cin != null ? cin.hashCode() : 0);
        result = 31 * result + (numeroPasseport != null ? numeroPasseport.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (preference != null ? preference.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "adresse='" + adresse + '\'' +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", numPasseport='" + numeroPasseport + '\'' +
                '}';
    }
}
