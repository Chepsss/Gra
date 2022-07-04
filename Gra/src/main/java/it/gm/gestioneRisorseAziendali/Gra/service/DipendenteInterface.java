package it.gm.gestioneRisorseAziendali.Gra.service;

import java.util.List;
import java.sql.Connection;


import it.gm.gestioneRisorseAziendali.Gra.entity.Dipendente;

public interface DipendenteInterface {
	
	 Dipendente saveDipendente(Dipendente dipendente);
	 List<Dipendente> getAllDipendente();
	 void deleteDipendente(int id);
	 Dipendente getById(int id);
	 Dipendente  updateDipendente(Dipendente dipendente);
	
	 List<Dipendente> searchByNomeDipendente( String nome);
	 List<Dipendente> searchByCognomeDipendente(String cognome);
	 List<Dipendente> searchByIdRuoloDipendente(int idRuolo);
	 List<Dipendente> searchByReparto(String reparto);	 
	 List<Dipendente> searchByNomeAndCognome(String nome,String cognome);
	 List<Dipendente> searchByNomeAndIdRuoloDipenente(String nome, int idRuolo);
	 List<Dipendente> searchByCognomeAndIdRuolo(String cognome, int idRuolo);	 
	 List<Dipendente> searchByNomeAndCognomeAndIdRuolo(String nome, String cognome,int idRuolo);
	 List<Dipendente> searchByNomeAndReparto(String nome,String reparto);	 
	 List<Dipendente> searchByCognomeAndReparto(String cognome,String reparto);	 
	 List<Dipendente> searchByRuoloAndReparto(int idRuolo,String reparto);
	 List<Dipendente> searchByNomeAndCognomeAndReparto(String nome,String cognome,String reparto); 
	 List<Dipendente> searchByNomeAndCognomeAndRuoloAndReparto(String nome,String cognome,int idRuolo, String reparto);

	 
	 

	 
	

}
