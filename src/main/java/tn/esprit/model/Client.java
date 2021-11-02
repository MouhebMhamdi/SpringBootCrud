package tn.esprit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long idClient ;
	private String  Nom ;
	private String Prenom ;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateNaissance ;
	public void setDateNaissance(Date dateNaissance) {
		DateNaissance = dateNaissance;
	}
	private String email ;
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	private CategorieClient categorie;
	
	@Enumerated(EnumType.ORDINAL)
	private Profession Proffesion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> factures;

	


	
	
}
