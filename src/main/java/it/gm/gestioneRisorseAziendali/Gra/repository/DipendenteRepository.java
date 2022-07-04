package it.gm.gestioneRisorseAziendali.Gra.repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.gm.gestioneRisorseAziendali.Gra.entity.Dipendente;


@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
	
	List<Dipendente> findAll();
	
	
	
	Dipendente findByNomeAndCognome(String nome,String cognome);
	
	
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
	
	@Query("FROM #{#entityName}  WHERE ruoloidruolo = :idRuolo")
	List<Dipendente> findByRuoloidruolo(int idRuolo);
	
	@Query("FROM #{#entityName}  WHERE ruoloidruolo = :idRuolo AND reparto LIKE :reparto%")
	List<Dipendente> findByRuoloidruoloAndRepartoAllIgnoreCaseStartingWith(int idRuolo,String reparto);	
	
	@Query("FROM #{#entityName}  WHERE ruoloidruolo = :idRuolo AND nome LIKE :nome% ")
	List<Dipendente> findByRuoloidruoloAndNomeAllIgnoreCaseStartingWith(int idRuolo,String nome);

	@Query("FROM #{#entityName}  WHERE cognome LIKE :cognome% AND ruoloidruolo = :idRuolo")
	List<Dipendente> findByCognomeAndRuoloidruoloAllIgnoreCaseStartingWith(int idRuolo,String cognome);

	@Query(value = "SELECT * FROM  dipendente WHERE  dataNascita BETWEEN  :dataNascitaStart AND  :dataNascitaEnd ", nativeQuery = true)
	List<Dipendente> findDipendenteByDataNascitaBetween(@Param ("dataNascitaStart")String dataNascitaStart,@Param ("dataNascitaEnd") String dataNascitaEnd);
		
	@Query(value = "FROM  #{entityName} WHERE idDipendente BETWEEN  :start AND  :end", nativeQuery = true)
	List<Dipendente> findByIdDipendenteBetween(@Param ("start") int start, @Param ("end") int end);
		
	/*
	@Query(value = "FROM  #{entityName} WHERE  idDipendente BETWEEN >= :start AND < :end" , nativeQuery = true)
	List<Dipendente> findByIdDipendente(Integer start);
	*/
//
//	@Query("FROM #{#entityName}  WHERE nome LIKE :nome% AND cognome LIKE :cognome% AND ruoloidruolo = :idRuolo")
//	List<Dipendente> findByNomeAndCognomeAndRuoloidruolo(String nome,String cognome,int idRuolo);
//
//	@Query("FROM #{#entityName}  WHERE nome LIKE :nome% AND cognome LIKE :cognome% AND reparto LIKE :reparto% AND ruoloidruolo = :idRuolo ")
//	List<Dipendente> findByNomeAndCognomeAndRepartoAndRuoloidruolo(String nome,String cognome,String reparto, int idRuolo);

	
}
