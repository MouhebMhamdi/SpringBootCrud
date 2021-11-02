package tn.esprit.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Fournisseur implements Serializable {
	@Override
	public String toString() {
		return "Fournisseur{" +
				"idFournisseur=" + idFournisseur +
				", code='" + code + '\'' +
				", libelle='" + libelle + '\'' +
				'}';
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFournisseur ;
	private String code;
	private String libelle;
	
	

	
}
