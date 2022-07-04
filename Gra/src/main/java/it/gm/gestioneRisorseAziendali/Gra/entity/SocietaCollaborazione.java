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
@Table(name="societacollaborazione")
public class SocietaCollaborazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 117081499936L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer idSocietacollaborazione;
	
	@NotNull
	@Column(name="tipologiacollaborazione")
	private String tipologiaCollaborazione;
	
	@NotNull
	@Column(name="nomesocieta")
	private String nomeSocieta;
	
	

	public Integer getIdsocietacollaborazione() {
		return idSocietacollaborazione;
	}

	public void setIdsocietacollaborazione(Integer idSocietacollaborazione) {
		this.idSocietacollaborazione = idSocietacollaborazione;
	}

	public String getTipologiaCollaborazione() {
		return tipologiaCollaborazione;
	}

	public void setTipologiaCollaborazione(String tipologiaCollaborazione) {
		this.tipologiaCollaborazione = tipologiaCollaborazione;
	}

	public String getNomeSocieta() {
		return this.nomeSocieta;
	}

	public void setNomeSocieta(String nomeSocieta) {
		this.nomeSocieta = nomeSocieta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSocietacollaborazione, nomeSocieta, tipologiaCollaborazione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocietaCollaborazione other = (SocietaCollaborazione) obj;
		return idSocietacollaborazione == other.idSocietacollaborazione && Objects.equals(nomeSocieta, other.nomeSocieta)
				&& Objects.equals(tipologiaCollaborazione, other.tipologiaCollaborazione);
	}

	@Override
	public String toString() {
		return "SocietaCollaborazione [idSocieta=" + idSocietacollaborazione + ", tipologiaCollaborazione=" + tipologiaCollaborazione
				+ ", nomeSocieta=" + nomeSocieta + "]";
	}
	

	
	
}
