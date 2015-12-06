package tn.insat.jebouquine.data.entity;

import java.util.Collection;


public class Panier {

	private int id;
	private double total;
	private Client client;
	private Collection<LigneCommande> lignesCommande;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
}
