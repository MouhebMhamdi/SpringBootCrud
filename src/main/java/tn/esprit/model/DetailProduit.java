package tn.esprit.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class DetailProduit implements Serializable {
	@Override
	public String toString() {
		return "DetailProduit{" +
				"idDetailProduit=" + idDetailProduit +
				", dateCreation=" + dateCreation +
				", datDernieremodification=" + datDernieremodification +
				", categorieProduit=" + categorieProduit +
				", produit=" + produit +
				'}';
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDetailProduit;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date datDernieremodification;
	
	@Enumerated(EnumType.ORDINAL)

	private CategorieProduit categorieProduit;
	@OneToOne(mappedBy="detailProduit")
	private Produit produit;


}
