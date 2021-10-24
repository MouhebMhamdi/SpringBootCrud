package tn.esprit.model;

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
@Entity
public class DetailProduit implements Serializable {
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

	public long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDatDernieremodification() {
		return datDernieremodification;
	}

	public void setDatDernieremodification(Date datDernieremodification) {
		this.datDernieremodification = datDernieremodification;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	} 
}
