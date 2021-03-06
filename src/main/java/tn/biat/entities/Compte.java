package tn.biat.entities;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="Comptes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
	@Id
	private String numero;
	private String proprietaire;
	private BigDecimal solde;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;

}
