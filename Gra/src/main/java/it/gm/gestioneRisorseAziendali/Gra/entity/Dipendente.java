package it.gm.gestioneRisorseAziendali.Gra.entity;

import java.io.Serializable;
import java.time.LocalDate;


import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.sun.istack.NotNull;



@Table(name="dipendente")
@Entity

public class Dipendente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1432635L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idDipendente;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@NotNull
	@Column(name="cognome")
	private String cognome;
	
	@NotNull
	@Column(name="datanascita")
	private LocalDate dataNascita;
	
	@NotNull
	@Column(name="dataassunzione")
	private LocalDate dataAssunzione;
	
	@NotNull
	@Column(name="reparto")
	private String reparto;
	
	@NotNull
	@JoinColumn(name="ruoloidruolo")
	@ManyToOne
	 private Ruolo ruolo;
	

	public Integer getIdDipendente() {
		return idDipendente;
	}

	public void setId(Integer idDipendente) {
		this.idDipendente = idDipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, dataAssunzione, dataNascita, idDipendente, nome, reparto, ruolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dipendente other = (Dipendente) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(dataAssunzione, other.dataAssunzione)
				&& Objects.equals(dataNascita, other.dataNascita) && Objects.equals(idDipendente, other.idDipendente)
				&& Objects.equals(nome, other.nome) && Objects.equals(reparto, other.reparto)
				&& Objects.equals(ruolo, other.ruolo);
	}

	@Override
	public String toString() {
		return "Dipendente [id Dipendente=" + idDipendente + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", dataAssunzione=" + dataAssunzione + ", reparto=" + reparto + ", ruolo=" + ruolo + "]";
	}

	
	
	
	
	
	
	
	
	
	
	

}
