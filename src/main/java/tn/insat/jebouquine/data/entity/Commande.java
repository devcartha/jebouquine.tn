package tn.insat.jebouquine.data.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commandes")
public class Commande {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String etat;
	private String dateCommande;
	private String modePaiement;
	private double fraisLivraison;
	private double total;
	private String adresseLivraison;
	@ManyToOne
    @JoinColumn(name = "client_id")
	private Client client;
	@OneToMany(cascade = CascadeType.ALL)
	private List<LigneCommande> lignesCommande;
	@OneToOne(mappedBy = "commande")
	private Facture facture;

    public Commande() {
    }

    public Commande(String etat, Date dateCommande, String modePaiement, double fraisLivraison, double total, String adresseLivraison) {
        this.etat = etat;
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        this.dateCommande = formater.format(dateCommande);
        this.modePaiement = modePaiement;
        this.fraisLivraison = fraisLivraison;
        this.total = total;
        this.adresseLivraison = adresseLivraison;
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

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        this.dateCommande = formater.format(dateCommande);
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

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(List<LigneCommande> lignesCommande) {
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
        result = id != null ? id.hashCode() : 0;
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
                "id=" + id +
                ", etat='" + etat + '\'' +
                ", dateCommande='" + dateCommande + '\'' +
                ", modePaiement='" + modePaiement + '\'' +
                ", fraisLivraison=" + fraisLivraison +
                ", total=" + total +
                ", adresseLivraison='" + adresseLivraison + '\'' +
                ", client=" + client +
                ", lignesCommande=" + lignesCommande +
                ", facture=" + facture +
                '}';
    }
}
