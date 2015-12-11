package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Clients")
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Size(min=5, max=20)
    private String login;
    private String password;
    private Date dateInscription;
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

    public Client(String login, String password, String nom, String prenom, String cin, String numeroPasseport, Date dateInscription, String email, String adresse, Preference preference) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.numeroPasseport = numeroPasseport;
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        this.dateInscription = /*formater.format(*/dateInscription/*)*/;
        this.email = email;
        this.adresse = adresse;
        this.preference = preference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        this.dateInscription = /*formater.format(*/dateInscription/*)*/;
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

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        if (nom != null ? !nom.equals(client.nom) : client.nom != null) return false;
        if (prenom != null ? !prenom.equals(client.prenom) : client.prenom != null) return false;
        if (cin != null ? !cin.equals(client.cin) : client.cin != null) return false;
        if (numeroPasseport != null ? !numeroPasseport.equals(client.numeroPasseport) : client.numeroPasseport != null)
            return false;
        if (dateInscription != null ? !dateInscription.equals(client.dateInscription) : client.dateInscription != null)
            return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;
        return !(preference != null ? !preference.equals(client.preference) : client.preference != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (cin != null ? cin.hashCode() : 0);
        result = 31 * result + (numeroPasseport != null ? numeroPasseport.hashCode() : 0);
        result = 31 * result + (dateInscription != null ? dateInscription.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (preference != null ? preference.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", numeroPasseport='" + numeroPasseport + '\'' +
                ", dateInscription='" + dateInscription + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", preference=" + preference +
                '}';
    }
}
