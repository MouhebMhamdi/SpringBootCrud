package tn.esprit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity 
public class Stock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idStock;
	private int qte;
	private int qtemin ;
	private String libellStock ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;
	
	
	public long getIdStock() {
		return idStock;
	}
	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getQtemin() {
		return qtemin;
	}
	public void setQtemin(int qtemin) {
		this.qtemin = qtemin;
	}
	public String getLibellStock() {
		return libellStock;
	}
	public void setLibellStock(String libellStock) {
		this.libellStock = libellStock;
	}
	
}
