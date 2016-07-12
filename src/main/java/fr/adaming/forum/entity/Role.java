package fr.adaming.forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Alonzo.M, Beauvironnois.F, Bonnecaze.K, Roblin.M
 * Cette classe d�fini les diff�rents roles possibles pour les utilisateurs.
 * C'est une classe � part pour permettre la modification et cr�ation des roles.
 *
 */

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	
	@NotNull
	private String status;

	public Role() {
		super();
	}

	public Role(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdRole() {
		return idRole;
	}
	
	

}
