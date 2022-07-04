package it.gm.gestioneRisorseAziendali.Gra.service;

import java.util.List;

import it.gm.gestioneRisorseAziendali.Gra.entity.SocietaCollaborazione;
import it.gm.gestioneRisorseAziendali.Gra.entity.Utente;



	public interface UtenteInterface {

	 Utente saveUtente(Utente utente);
	 Utente checkUtente(Utente utente);
	 List<Utente> getAllUtente();
	 void deleteUtente(int id);
	 Utente recuperaUtente(int id);
	 Utente updateUtente(Utente utente);
	 
	 
	 List<Utente> searchByNomeUtente(String nome);
	 List<Utente> searchByEmail(String email);
	 List<Utente> searchByNomeUtenteAndEmail(String nomeUtente,String email);
	 List<Utente> searchBySocietaCollaborazione(SocietaCollaborazione sC);
	 
	

}
	
	
