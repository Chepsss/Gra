package it.gm.gestioneRisorseAziendali.Gra.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="ruolo")
public class Ruolo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 124314L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idRuolo;
	
	@NotNull
	@Column(name="nomeRuolo")
	private String nomeRuolo;
	
	@NotNull
	@Column(name="dataCreazione")
	private LocalDate dataCreazione;
	
	
	public Integer getIdRuolo() {
		return idRuolo;
	}
	
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	public String getNomeRuolo() {
		return nomeRuolo;
	}
	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}
	public LocalDate getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dataCreazione, idRuolo, nomeRuolo);
	}

	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", nomeRuolo=" + nomeRuolo + ", dataCreazione=" + dataCreazione + "]";
	}
	

	
	
	
	
	

}
