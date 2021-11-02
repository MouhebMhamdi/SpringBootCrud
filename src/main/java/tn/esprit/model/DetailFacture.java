package tn.esprit.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class DetailFacture implements Serializable {
	@Override
	public String toString() {
		return "DetailFacture{" +
				"idDetailFacture=" + idDetailFacture +
				", DateCreation=" + DateCreation +
				", DateDernierModification=" + DateDernierModification +
				", CategorieProduit=" + CategorieProduit +
				", produits=" + produits +
				", facture=" + facture +
				'}';
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDetailFacture ;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateCreation ;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateDernierModification ;
	@Enumerated(EnumType.ORDINAL)
	private CategorieProduit CategorieProduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="detailFacture")
	private Set<Produit> produits;
	@ManyToOne
	Facture facture;

	


}
