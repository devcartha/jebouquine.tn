package tn.insat.jebouquine.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "lignesCommande")
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double prix;
	private int quantite;
	@ManyToOne
    @JoinColumn(name = "ouvrage_id")
	private Ouvrage ouvrage;
    @ManyToOne
    private Commande commande;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
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

        LigneCommande that = (LigneCommande) o;

        if (Double.compare(that.prix, prix) != 0) return false;
        if (quantite != that.quantite) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ouvrage != null ? !ouvrage.equals(that.ouvrage) : that.ouvrage != null) return false;
        return !(commande != null ? !commande.equals(that.commande) : that.commande != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantite;
        result = 31 * result + (ouvrage != null ? ouvrage.hashCode() : 0);
        result = 31 * result + (commande != null ? commande.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", ouvrage=" + ouvrage +
                '}';
    }
}
