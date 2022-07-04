package it.gm.gestioneRisorseAziendali.Gra.service;

import java.util.List;

import it.gm.gestioneRisorseAziendali.Gra.entity.Ruolo;



public interface RuoloInterface {
	
	Ruolo saveRuolo(Ruolo ruolo);
	 List<Ruolo> getAllRuolo();
	 void deleteRuolo(int idRuolo);
	 Ruolo getByIdRuolo(int idRuolo);
	 Ruolo  updateRuolo(Ruolo ruolo);

}
