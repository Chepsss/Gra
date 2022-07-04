package it.gm.gestioneRisorseAziendali.Gra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.gm.gestioneRisorseAziendali.Gra.entity.Dipendente;

@Repository
public interface DipendenteRepository extends CrudRepository<Dipendente, Integer> {
	
	List<Dipendente> findAll();
	
	@Query("FROM #{#entityName} WHERE nome LIKE :nome%")
	List<Dipendente> findByNomeAllIgnoreCaseStartingWith(@Param ("nome") String nome);
	
	@Query("FROM #{#entityName} WHERE cognome LIKE :cognome%")
	List<Dipendente> findByCognomeAllIgnoreCaseStartingWith(@Param ("cognome") String cognome);
	
	@Query("FROM #{#entityName} WHERE reparto LIKE :reparto%")
	List<Dipendente> findByRepartoAllIgnoreCaseStartingWith(@Param ("reparto") String reparto);
	
	@Query("FROM #{#entityName} WHERE nome LIKE :nome% AND cognome LIKE :cognome%")
	List<Dipendente> findByNomeAndCognomeAllIgnoreCaseStartingWith(String nome,String cognome);
	
	@Query("FROM #{#entityName} WHERE nome LIKE :nome% AND reparto LIKE :reparto%")
	List<Dipendente> findByNomeAndRepartoAllIgnoreCaseStartingWith(String nome,String reparto);
	
	@Query("FROM #{#entityName} WHERE cognome LIKE :cognome% AND reparto LIKE :reparto%")
	List<Dipendente> findByCognomeAndRepartoAllIgnoreCaseStartingWith(String cognome,String reparto);
	
	@Query("FROM #{#entityName} WHERE nome LIKE :nome% AND cognome LIKE :cognome% AND reparto LIKE :reparto%")
	List<Dipendente> findByNomeAndCognomeAndRepartoAllIgnoreCaseStartingWith(String nome,String cognome,String reparto);
	
	List<Dipendente> findByRuoloAndReparto(int idRuolo,String reparto);	
	List<Dipendente> findByRuolo(int idRuolo);
	List<Dipendente> findByNomeAndRuolo(String nome,int idRuolo);
	List<Dipendente> findByCognomeAndRuolo(String nome,int idRuolo);
	List<Dipendente> findByNomeAndCognomeAndRuolo(String nome,String cognome,int idRuolo);
	List<Dipendente> findByNomeAndCognomeAndRuoloAndReparto(String nome,String cognome,int idRuolo,String reparto);
}
