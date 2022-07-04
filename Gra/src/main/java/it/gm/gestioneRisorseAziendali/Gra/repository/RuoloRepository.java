package it.gm.gestioneRisorseAziendali.Gra.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.gm.gestioneRisorseAziendali.Gra.entity.Ruolo;

@Repository
public interface RuoloRepository extends CrudRepository<Ruolo, Integer> {
	
	List <Ruolo> findAll();

}
