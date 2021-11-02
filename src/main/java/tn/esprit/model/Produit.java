package tn.esprit.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Produit implements Serializable {
	@Override
	public String toString() {
		return "Produit{" +
				"idProduit=" + idProduit +
				", code='" + code + '\'' +
				", idlibelle='" + idlibelle + '\'' +
				", idprixUnitaire=" + idprixUnitaire +
				", fournisseurProduit=" + fournisseurProduit +
				", rayon=" + rayon +
				", detailFacture=" + detailFacture +
				", detailProduit=" + detailProduit +
				", stock=" + stock +
				'}';
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  idProduit; 
	private String  code; 
	private String  idlibelle;
	private float  idprixUnitaire;

	@ManyToMany(targetEntity=Fournisseur.class,cascade=CascadeType.MERGE)
	private Set<Fournisseur> fournisseurProduit;

	public Set<Fournisseur> getFournisseurProduit() {
		return fournisseurProduit;
	}

	public void setFournisseurProduit(Set<Fournisseur> fournisseurProduit) {
		this.fournisseurProduit = fournisseurProduit;
	}

	@ManyToOne
	Rayon rayon;
	@ManyToOne
	DetailFacture detailFacture;
	@OneToOne
	private DetailProduit detailProduit;
	@ManyToOne
	Stock stock;




}
