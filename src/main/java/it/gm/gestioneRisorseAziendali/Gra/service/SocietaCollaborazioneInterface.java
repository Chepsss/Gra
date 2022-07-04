package it.gm.gestioneRisorseAziendali.Gra.service;

import java.util.List;

import it.gm.gestioneRisorseAziendali.Gra.entity.SocietaCollaborazione;

public interface SocietaCollaborazioneInterface {
	
	 SocietaCollaborazione saveSocietaCollaborazione(SocietaCollaborazione sc);
	 List<SocietaCollaborazione> getAllSocietaCollaborazione();
	 void deleteSocietaCollaborazione(int idSocColl);
	 SocietaCollaborazione getByIdRSocietaCollaborazione(int idSocColl);
	 SocietaCollaborazione  updateSocietaCollaborazione(SocietaCollaborazione sc);
	 SocietaCollaborazione getByTipologiaCollaborazione(String nomeSoc);

}
