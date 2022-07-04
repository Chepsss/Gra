package it.gm.gestioneRisorseAziendali.Gra.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import it.gm.gestioneRisorseAziendali.Gra.entity.SocietaCollaborazione;




@Repository
public interface SocietaCollaborazioneRepository extends CrudRepository<SocietaCollaborazione, Integer>  {
	
	List <SocietaCollaborazione> findAll();
	SocietaCollaborazione findByTipologiaCollaborazione(String tipologiaCollaborazione);

}
