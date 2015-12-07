package tn.insat.jebouquine.data.entity;

import java.util.Collection;


public class Panier {

	private Long id;
	private double total;
	private Client client;
	private Collection<LigneCommande> lignesCommande;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Panier panier = (Panier) o;

		if (Double.compare(panier.total, total) != 0) return false;
		if (id != null ? !id.equals(panier.id) : panier.id != null) return false;
		if (client != null ? !client.equals(panier.client) : panier.client != null) return false;
		return !(lignesCommande != null ? !lignesCommande.equals(panier.lignesCommande) : panier.lignesCommande != null);

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		temp = Double.doubleToLongBits(total);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (client != null ? client.hashCode() : 0);
		result = 31 * result + (lignesCommande != null ? lignesCommande.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Panier{" +
				"id=" + id +
				", total=" + total +
				", client=" + client +
				", lignesCommande=" + lignesCommande +
				'}';
	}
}
