package tn.esprit.model;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity 
public class Stock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idStock;
	private int qte;
	private int qtemin ;

	@Override
	public String toString() {
		return "Stock{" +
				"idStock=" + idStock +
				", qte=" + qte +
				", qtemin=" + qtemin +
				", libellStock='" + libellStock + '\'' +
				", produits=" + produits +
				'}';
	}

	private String libellStock ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;
	
	

	
}
