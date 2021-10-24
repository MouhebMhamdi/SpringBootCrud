package tn.esprit.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;



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

	
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CategorieClient getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieClient categorie) {
		this.categorie = categorie;
	}
	
	public Profession getProffesion() {
		return Proffesion;
	}
	public void setProffesion(Profession proffesion) {
		Proffesion = proffesion;
	}
	
	
	
	
}
