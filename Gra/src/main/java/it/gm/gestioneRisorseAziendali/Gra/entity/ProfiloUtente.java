package it.gm.gestioneRisorseAziendali.Gra.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="profiloutente")
public class ProfiloUtente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9876543L;
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProfiloUtente;
	
	@NotNull
	@Column(name="nomeProfilo")
	private String nomeProfilo;
	
	public ProfiloUtente(Integer idProfiloUtente, String nomeProfilo) {
		super();
		this.idProfiloUtente = idProfiloUtente;
		this.nomeProfilo = nomeProfilo;
	}
	public ProfiloUtente(){
		
	}

	public Integer getIdProfiloUtente() {
		return idProfiloUtente;
	}

	public void setIdProfiloUtente(Integer idProfiloUtente) {
		this.idProfiloUtente = idProfiloUtente;
	}

	public String getNomeProfilo() {
		return nomeProfilo;
	}

	public void setNomeProfilo(String nomeProfilo) {
		this.nomeProfilo = nomeProfilo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProfiloUtente, nomeProfilo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfiloUtente other = (ProfiloUtente) obj;
		return idProfiloUtente == other.idProfiloUtente && Objects.equals(nomeProfilo, other.nomeProfilo);
	}

	@Override
	public String toString() {
		return "ProfiloUtente [idProfiloUtente=" + idProfiloUtente + ", nomeProfilo=" + nomeProfilo + "]";
	}
	
	
	

}
