package it.gm.gestioneRisorseAziendali.Gra.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.gm.gestioneRisorseAziendali.Gra.entity.Dipendente;
import it.gm.gestioneRisorseAziendali.Gra.service.DipendenteInterface;
import it.gm.gestioneRisorseAziendali.Gra.utility.DateSearcher;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dipendente")
public class DipendenteController {

	@Autowired
	private DipendenteInterface serviceDip;

	@PostMapping(value = "/saveDipendente")
	public @ResponseBody Dipendente createNewDipendente(@RequestBody Dipendente dipendente) {

		Dipendente dipSalvato = null;

		dipSalvato = serviceDip.saveDipendente(dipendente);

		System.out.println("Dipendente salvato" + dipSalvato);
		return dipSalvato;

	}

	@GetMapping(value = "/doListDipendenti")
	public @ResponseBody List<Dipendente> getDipendenteList() {

		List<Dipendente> listaDipendenti = serviceDip.getAllDipendente();
		System.out.println(listaDipendenti);
		return listaDipendenti;
	}

	@DeleteMapping(value = "/deleteDipendente/{id}")
	public void deleteById(@PathVariable Integer id) {

		serviceDip.deleteDipendente(id);

		System.out.println("Dipendente  cancellato");

	}

	@GetMapping(value = "/recuperaDipendente/{id}")
	public @ResponseBody Dipendente recuperaDipendente(@PathVariable Integer id) {

		Dipendente dipendenteChecked = serviceDip.getById(id);
		System.out.println("Dipendente recuperato con id ;)) " + dipendenteChecked);

		return dipendenteChecked;

	}
	

	@PutMapping(value = "/updateDipendente/{id}")
	public @ResponseBody Dipendente updateUsers(@PathVariable Integer id, @RequestBody Dipendente dipendente) {
		Dipendente dipendenteUpdated = serviceDip.updateDipendente(dipendente);
		
		System.out.println("Dipendente aggiornato "+dipendenteUpdated);

		return dipendenteUpdated;

	}
	@PostMapping(value = "/dipEsistente")
	public @ResponseBody Dipendente recuperaDipNomeCognomeData(@RequestBody Dipendente dipendente) {

		Dipendente dipChecked = serviceDip.getByNomeCognomeData(dipendente);
		System.out.println("Utente recuperato con nome,cognome ;)) " + dipChecked);

		return dipChecked;

	}

	@PostMapping(value = "/search")

	public @ResponseBody List<Dipendente> researches(@RequestBody Dipendente dipendente) {
		List<Dipendente> risultatiRicerca = new ArrayList<>();
		System.out.println("dipendente arrivato dal front end in search " + dipendente.toString());

		if (!dipendente.getNome().matches("") && dipendente.getCognome().matches("")
				&& dipendente.getReparto().matches("") && dipendente.getRuolo() == null
				) {
			risultatiRicerca = serviceDip.searchByNomeDipendente(dipendente.getNome());
			System.out.println(risultatiRicerca.toString());
			
		}

		else if (dipendente.getNome().equals("") && !dipendente.getCognome().equals("")
				&& dipendente.getReparto().equals("") && dipendente.getRuolo() == null
				&& dipendente.getDataNascita() == null) {
			risultatiRicerca = serviceDip.searchByCognomeDipendente(dipendente.getCognome());
			System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;

		}

		else if (dipendente.getNome().equals("") && dipendente.getCognome().equals("")
				&& !dipendente.getReparto().equals("") && dipendente.getRuolo() == null 
				&& dipendente.getDataNascita() == null) {
			risultatiRicerca = serviceDip.searchByReparto(dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;

		}
		else if (dipendente.getNome().equals("") && dipendente.getCognome().equals("")
				&& dipendente.getReparto().equals("") && dipendente.getRuolo() != null 
				&& dipendente.getDataNascita() == null) {
			

			risultatiRicerca = serviceDip.searchByIdRuoloDipendente(dipendente.getRuolo().getIdRuolo());
			System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;

		}

		else if (!dipendente.getNome().equals("") && !dipendente.getCognome().equals("")
				&& dipendente.getReparto().equals("") && dipendente.getRuolo() == null 
				&& dipendente.getDataNascita() == null) {

			risultatiRicerca = serviceDip.searchByNomeAndCognome(dipendente.getNome(), dipendente.getCognome());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}

		else if (!dipendente.getNome().equals("") && !dipendente.getReparto().equals("")
				&& dipendente.getCognome().equals("") && dipendente.getRuolo() == null 
				&& dipendente.getDataNascita() == null) {
			risultatiRicerca = serviceDip.searchByNomeAndReparto(dipendente.getNome(), dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}

		else if (!dipendente.getCognome().equals("") && !dipendente.getReparto().equals("")
				&& dipendente.getNome().equals("") && dipendente.getRuolo() == null 
				&& dipendente.getDataNascita() == null) {
			risultatiRicerca = serviceDip.searchByCognomeAndReparto(dipendente.getCognome(), dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}
		else if (dipendente.getCognome().equals("") && !dipendente.getReparto().equals("")
				&& dipendente.getNome().equals("") && dipendente.getRuolo() != null 
				&& dipendente.getDataNascita() == null) {
			risultatiRicerca = serviceDip.searchByRuoloAndReparto(dipendente.getRuolo().getIdRuolo(), dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}
		else if (dipendente.getCognome().equals("") && dipendente.getReparto().equals("")
				&& !dipendente.getNome().equals("") && dipendente.getRuolo() != null 
				&& dipendente.getDataNascita() == null) {
			risultatiRicerca = serviceDip.searchByNomeAndIdRuoloDipendente (dipendente.getRuolo().getIdRuolo(),dipendente.getNome() );
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}
		else if (!dipendente.getCognome().equals("") && dipendente.getReparto().equals("")
				&& dipendente.getNome().equals("") && dipendente.getRuolo() != null 
				&& dipendente.getDataNascita() == null) {
			risultatiRicerca = serviceDip.searchByCognomeAndIdRuolo(dipendente.getRuolo().getIdRuolo(),dipendente.getCognome() );
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}

		else if (!dipendente.getNome().equals("") && !dipendente.getCognome().equals("")
				&& !dipendente.getReparto().equals("") && dipendente.getRuolo() == null
				&& dipendente.getDataNascita() == null ) {
			risultatiRicerca = serviceDip.searchByNomeAndCognomeAndReparto(dipendente.getNome(),
					dipendente.getCognome(), dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}
		

		return risultatiRicerca;

	}
	
	@GetMapping(value = "/searchById/{start}")
	public @ResponseBody List<Dipendente>searchIdRange(Integer start){
		
		//Integer end =100;
		List<Dipendente> result = new ArrayList<>();
		System.out.println("start id  "+start);
		//System.out.println("end id  "+end);
		//result = serviceDip.searchByRangeId(start);
		System.out.println("risultato cerca per range id "+result);
		return result;
	}
	
	
	@PostMapping(value = "/searchByData")

	public @ResponseBody List<Dipendente> searchDate(@RequestBody DateSearcher dS) {
		
		
		List<Dipendente> risultatiRicerca = new ArrayList<>();
		System.out.println("oggetto data in impl " + dS);
		

        risultatiRicerca =serviceDip.searchByData(dS.getStartDate(),
        		dS.getEndDate());
					System.out.println("Lista risultati ricerca "+risultatiRicerca);
			
		
		//List<Dipendente> result = new ArrayList<>();
		System.out.println("start id  "+dS.getStartDate());
		System.out.println("end id  "+dS.getEndDate());
		//result = serviceDip.searchByRangeId(1,100);
		System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;
			
			}
	
	
	
	
}
