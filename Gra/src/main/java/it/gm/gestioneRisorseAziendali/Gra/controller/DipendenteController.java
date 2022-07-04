package it.gm.gestioneRisorseAziendali.Gra.controller;

import java.sql.Connection;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.gm.gestioneRisorseAziendali.Gra.entity.Dipendente;
import it.gm.gestioneRisorseAziendali.Gra.service.DipendenteInterface;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/dipendente")
public class DipendenteController {
	
	@Autowired
	private DipendenteInterface serviceDip;
	
	Connection con;
	
	
	
	
	@PostMapping(value="/saveDipendente")
	public @ResponseBody Dipendente createNewDipendente(@RequestBody Dipendente dipendente) {
		
		Dipendente dipSalvato = null;
		
		dipSalvato = serviceDip.saveDipendente(dipendente);
		
		System.out.println("Dipendente salvato"+dipSalvato);
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
		
		System.out.println("Utente  cancellato"   );
	   
	  }
	
	
	@GetMapping(value = "/recuperaDipendente/{id}")
	 public @ResponseBody Dipendente recuperaDipendente(@PathVariable Integer id) {
		
		Dipendente dipendenteChecked = serviceDip.getById(id);
		System.out.println("Dipendente recuperato con id ;)) "+dipendenteChecked);
		
		
		return dipendenteChecked;
      
  }
	
	@PutMapping(value = "/updateDipendente")
	 public @ResponseBody Dipendente updateUsers(@RequestBody Dipendente dipendente) {
		
		Dipendente dipendenteUpdated = serviceDip.updateDipendente(dipendente);
		System.out.println(dipendenteUpdated);
		
		
		return dipendenteUpdated;
     
 }
	
	@PostMapping(value = "/search")
	
	 public  @ResponseBody List  <Dipendente> researches(@RequestBody Dipendente dipendente) {
		List <Dipendente> risultatiRicerca = new ArrayList<>();
		System.out.println("dipendente arrivato dal fron end " + dipendente.toString());
		
		if(!dipendente.getNome().matches("") && dipendente.getCognome().equals("") &&  dipendente.getReparto().equals("")) {
			risultatiRicerca = serviceDip.searchByNomeDipendente(dipendente.getNome());
			System.out.println(risultatiRicerca.toString());
		return risultatiRicerca;
		}
			
		
		else if(dipendente.getNome().equals("") && !dipendente.getCognome().equals("") &&  dipendente.getReparto().equals("")) {
			risultatiRicerca = serviceDip.searchByCognomeDipendente(dipendente.getCognome());
			System.out.println(risultatiRicerca.toString());	
			return risultatiRicerca;
	
		}
		
		
		else if(dipendente.getNome().equals("") && dipendente.getCognome().equals("") &&  !dipendente.getReparto().equals("") ) {
			risultatiRicerca = serviceDip.searchByReparto(dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;

		}
		
		else if(!dipendente.getNome().equals("") && !dipendente.getCognome().equals("") && dipendente.getReparto().equals("") ) {
			
			 risultatiRicerca = serviceDip.searchByNomeAndCognome(dipendente.getNome(), dipendente.getCognome());
				System.out.println(risultatiRicerca.toString());

			 return risultatiRicerca;
		}
		
		
		else if(!dipendente.getNome().equals("") && !dipendente.getReparto().equals("") && dipendente.getCognome().equals("") ) {
			risultatiRicerca = serviceDip.searchByNomeAndReparto(dipendente.getNome(), dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}
		
		else if(!dipendente.getCognome().equals("") && !dipendente.getReparto().equals("") && dipendente.getNome().equals("")) {
			risultatiRicerca = serviceDip.searchByCognomeAndReparto(dipendente.getCognome(), dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}
		
		
		else if(!dipendente.getNome().equals("") && !dipendente.getCognome().equals("") && !dipendente.getReparto().equals("")) {
			risultatiRicerca = serviceDip.searchByNomeAndCognomeAndReparto(dipendente.getNome(),dipendente.getCognome(), dipendente.getReparto());
			System.out.println(risultatiRicerca.toString());

			return risultatiRicerca;
		}
	
		return risultatiRicerca;
	
}
	
	
	

}
