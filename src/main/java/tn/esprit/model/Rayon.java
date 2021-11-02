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
public class Rayon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idRayon ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> produits;

	String code ;
	String libelle;
}
