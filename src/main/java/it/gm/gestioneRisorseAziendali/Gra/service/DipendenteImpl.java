package it.gm.gestioneRisorseAziendali.Gra.service;




import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gm.gestioneRisorseAziendali.Gra.entity.Dipendente;

import it.gm.gestioneRisorseAziendali.Gra.repository.DipendenteRepository;

@Service
@Transactional
public class DipendenteImpl implements DipendenteInterface {
	
	@Autowired
	private DipendenteRepository repository;

	@Override
	public Dipendente saveDipendente(Dipendente dipendente) {
	Dipendente dipendenteSalvato = new Dipendente();
		
		try {
			dipendenteSalvato=repository.save(dipendente);
			return dipendenteSalvato;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}


	

	@Override
	public List<Dipendente> getAllDipendente() {
		List<Dipendente> listaDipendenti = new ArrayList<>();
		
		try {
			listaDipendenti = repository.findAll();
			return listaDipendenti;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteDipendente(int id) {
		
		repository.deleteById(id);;
		
			
	}

	@Override
	public Dipendente getById(int id) {
		Dipendente dipendente = new Dipendente();
		
		try {
			dipendente=repository.findById(id).get();
			return dipendente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public Dipendente updateDipendente(Dipendente dipendente) {
		Dipendente dipendenteAggiornato = new Dipendente();
		
		try {
			dipendenteAggiornato=repository.save(dipendente);
			return dipendenteAggiornato;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}




	
	
	@Override
	public List<Dipendente> searchByNomeDipendente(String nome) {
		List <Dipendente> listaPerCognome	= new ArrayList <>();
		try {
			
			listaPerCognome = repository.findByNomeAllIgnoreCaseStartingWith(nome);
			return listaPerCognome;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}



	@Override
	public List<Dipendente> searchByCognomeDipendente(String cognome) {
		List <Dipendente> listaPerCognome	= new ArrayList <>();
		try {
			
			listaPerCognome = repository.findByCognomeAllIgnoreCaseStartingWith(cognome);
			return listaPerCognome;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}





	@Override
	public List<Dipendente> searchByIdRuoloDipendente(int idRuolo) {
		List<Dipendente> dip	= new ArrayList <> ();
		try {
			
			dip = repository.findByRuoloidruolo(idRuolo);
			return dip;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	

	@Override
	public List<Dipendente> searchByReparto(String reparto) {
		List <Dipendente> listaPerReparto	= new ArrayList <>();
		try {
			
			listaPerReparto = repository.findByRepartoAllIgnoreCaseStartingWith(reparto);;
			return listaPerReparto;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}






	@Override
	public List<Dipendente> searchByNomeAndCognome(String nome, String cognome) {
		List <Dipendente> listaPerNomeAndCognome	= new ArrayList <>();
		try {
			
			listaPerNomeAndCognome = repository.findByNomeAndCognomeAllIgnoreCaseStartingWith(nome, cognome);
			return listaPerNomeAndCognome;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}







	@Override
	public List<Dipendente> searchByNomeAndReparto(String nome, String reparto) {
		List <Dipendente> listaPerNomeAndReparto	= new ArrayList <>();
		try {
			
			listaPerNomeAndReparto = repository.findByNomeAndRepartoAllIgnoreCaseStartingWith(nome,reparto);;
			return listaPerNomeAndReparto;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}





	@Override
	public List<Dipendente> searchByCognomeAndReparto(String cognome, String reparto) {
		List <Dipendente> listaPerCognomeAndReparto	= new ArrayList <>();
		try {
			
			listaPerCognomeAndReparto = repository.findByCognomeAndRepartoAllIgnoreCaseStartingWith(cognome,reparto);;
			return listaPerCognomeAndReparto;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}




	@Override
	public List<Dipendente> searchByRuoloAndReparto(int idRuolo, String reparto) {
		List <Dipendente> listaPerRuoloAndReparto	= new ArrayList <>();
		try {
			
			listaPerRuoloAndReparto = repository.findByRuoloidruoloAndRepartoAllIgnoreCaseStartingWith(idRuolo,reparto);;
			return listaPerRuoloAndReparto;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}



	@Override
	public List<Dipendente> searchByNomeAndCognomeAndReparto(String nome, String cognome, String reparto) {
		List <Dipendente> listaPerNomeAndCognomeAndReparto	= new ArrayList <>();
		try {
			
			listaPerNomeAndCognomeAndReparto = repository.findByNomeAndCognomeAndRepartoAllIgnoreCaseStartingWith(nome, cognome, reparto);
			return listaPerNomeAndCognomeAndReparto;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}




	@Override
	public List<Dipendente> searchByNomeAndIdRuoloDipendente( int idRuolo, String nome ) {
		List <Dipendente> listaPerNomeAndRuolo	= new ArrayList <>();
		try {
			
			listaPerNomeAndRuolo = repository.findByRuoloidruoloAndNomeAllIgnoreCaseStartingWith(idRuolo,  nome);
			return listaPerNomeAndRuolo;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}




	@Override
	public List<Dipendente> searchByCognomeAndIdRuolo(int idRuolo,String cognome ) {
		List <Dipendente> listaPerCognomeAndRuolo	= new ArrayList <>();
		try {
			
			listaPerCognomeAndRuolo = repository.findByCognomeAndRuoloidruoloAllIgnoreCaseStartingWith(idRuolo,  cognome);
			return listaPerCognomeAndRuolo;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Dipendente> searchByRangeId(int start, int end) {
		List<Dipendente> listaRangeId = new ArrayList<>();
		try {
			listaRangeId= repository.findByIdDipendenteBetween(start, end);
			return listaRangeId;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}



	@Override
	public List<Dipendente> searchByData(String start,String end) {
		System.out.println("start in Impl "+ start);
		System.out.println("end in Impl " + end);
				List <Dipendente> listaPerData	= new ArrayList <>();
				
	try {
		

		listaPerData = repository.findDipendenteByDataNascitaBetween(start,end);
		System.out.println("lista per data in searchByData "+ listaPerData);
			return listaPerData;
		}catch(Exception ex) {
			ex.printStackTrace();		}
	return null;
	}

	@Override
	public List<Dipendente> searchByNomeAndCognomeAndIdRuolo(String nome, String cognome, int idRuolo) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Dipendente> searchByNomeAndCognomeAndRuoloAndReparto(String nome, String cognome, int idRuolo,String reparto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Dipendente getByNomeCognomeData(Dipendente dip) {
	Dipendente dipendente = new Dipendente();
		
		try {
			dipendente=repository.findByNomeAndCognome(dip.getNome(), dip.getCognome());
			return dipendente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	

	}





}
	



	



	




	




//	@Override
//	public List<Dipendente> searchByNomeAndCognomeAndRuoloAndReparto(String nome, String cognome, int idRuolo,String reparto) {
//		List <Dipendente> listaPerNomeAndCognomeAndRuoloAndReparto	= new ArrayList <>();
//		try {
//			
//			listaPerNomeAndCognomeAndRuoloAndReparto = repository.findByNomeAndCognomeAndRepartoAndRuoloidruolo(nome, cognome,reparto ,idRuolo );
//			return listaPerNomeAndCognomeAndRuoloAndReparto;
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return null;
//	}




	


