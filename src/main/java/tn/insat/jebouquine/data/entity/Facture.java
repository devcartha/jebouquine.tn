package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "factures")
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String etat;
    private String dateFacturation;
	@OneToOne
	private Commande commande;

    public Facture() {
    }

    public Facture(String etat, Date dateFacturation, Commande commande) {
        this.etat = etat;
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        this.dateFacturation = formater.format(dateFacturation);
        this.commande = commande;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        this.dateFacturation = formater.format(dateFacturation);
    }

    public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facture facture = (Facture) o;

        if (id != null ? !id.equals(facture.id) : facture.id != null) return false;
        if (etat != null ? !etat.equals(facture.etat) : facture.etat != null) return false;
        if (dateFacturation != null ? !dateFacturation.equals(facture.dateFacturation) : facture.dateFacturation != null)
            return false;
        return !(commande != null ? !commande.equals(facture.commande) : facture.commande != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + (dateFacturation != null ? dateFacturation.hashCode() : 0);
        result = 31 * result + (commande != null ? commande.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", etat='" + etat + '\'' +
                ", dateFacturation=" + dateFacturation +
                '}';
    }
}
