package it.gm.gestioneRisorseAziendali.Gra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.gm.gestioneRisorseAziendali.Gra.entity.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Integer>{
	
	
	
	Utente findByEmailAndPassword(String email,String password);
	List<Utente> findAll();
	
	@Query("FROM #{#entityName} WHERE nomeUtente LIKE :nomeUtente%")
	List<Utente>findByNomeUtenteAllIgnoreCaseStartingWith(@Param ("nomeUtente") String nomeUtente);
	
	@Query("FROM #{#entityName} WHERE email LIKE :email%")
	List<Utente> findByEmailAllIgnoreCaseStartingWith(@Param ("email") String email);
	
	@Query("FROM #{#entityName} WHERE nome LIKE :nomeUtente% AND email LIKE :email%")
	List<Utente>findByNomeUtenteAndEmailAllIgnoreCaseStartingWith(@Param ("nomeUtente") String nomeUtente,@Param ("email") String email);
	
	//@Query("FROM #{#entityName} WHERE societaCollaborazione LIKE :societaCollaborazione%")
	//List<Utente> findBySocietaCollaborazioneAllIgnoreCaseStartingWith(@Param ("societaCollaborazione")SocietaCollaborazione societaCollaborazione);
}
