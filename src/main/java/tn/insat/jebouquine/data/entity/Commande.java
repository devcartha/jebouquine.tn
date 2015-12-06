package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "commandes")
public class Commande {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String etat;
	private Date dateCommande;
	private String modePaiement;
	private double fraisLivraison;
	private double total;
	private String adresseLivraison;
	@ManyToOne
    @JoinColumn(name = "client_id")
	private Client client;
	@OneToMany(mappedBy = "commande")
	private Collection<LigneCommande> lignesCommande;
	@OneToOne(mappedBy = "commande")
	private Facture facture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public double getFraisLivraison() {
        return fraisLivraison;
    }

    public void setFraisLivraison(double fraisLivraison) {
        this.fraisLivraison = fraisLivraison;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(Collection<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (id != commande.id) return false;
        if (Double.compare(commande.fraisLivraison, fraisLivraison) != 0) return false;
        if (Double.compare(commande.total, total) != 0) return false;
        if (etat != null ? !etat.equals(commande.etat) : commande.etat != null) return false;
        if (dateCommande != null ? !dateCommande.equals(commande.dateCommande) : commande.dateCommande != null)
            return false;
        if (modePaiement != null ? !modePaiement.equals(commande.modePaiement) : commande.modePaiement != null)
            return false;
        if (adresseLivraison != null ? !adresseLivraison.equals(commande.adresseLivraison) : commande.adresseLivraison != null)
            return false;
        if (client != null ? !client.equals(commande.client) : commande.client != null) return false;
        if (lignesCommande != null ? !lignesCommande.equals(commande.lignesCommande) : commande.lignesCommande != null)
            return false;
        return !(facture != null ? !facture.equals(commande.facture) : commande.facture != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + (dateCommande != null ? dateCommande.hashCode() : 0);
        result = 31 * result + (modePaiement != null ? modePaiement.hashCode() : 0);
        temp = Double.doubleToLongBits(fraisLivraison);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (adresseLivraison != null ? adresseLivraison.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (lignesCommande != null ? lignesCommande.hashCode() : 0);
        result = 31 * result + (facture != null ? facture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "client=" + client +
                ", adresseLivraison='" + adresseLivraison + '\'' +
                ", total=" + total +
                ", fraisLivraison=" + fraisLivraison +
                ", modePaiement='" + modePaiement + '\'' +
                ", dateCommande=" + dateCommande +
                ", etat='" + etat + '\'' +
                ", id=" + id +
                '}';
    }
}
