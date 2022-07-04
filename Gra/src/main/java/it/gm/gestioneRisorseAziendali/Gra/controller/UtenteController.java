package it.gm.gestioneRisorseAziendali.Gra.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.gm.gestioneRisorseAziendali.Gra.entity.Dipendente;
import it.gm.gestioneRisorseAziendali.Gra.entity.ProfiloUtente;
import it.gm.gestioneRisorseAziendali.Gra.entity.Utente;
import it.gm.gestioneRisorseAziendali.Gra.service.UtenteInterface;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	private	UtenteInterface serviceUtente;
	
	
	

	
	
	@PostMapping(value="/doSignIn")
	public @ResponseBody Utente createNewUtente(@RequestBody Utente utente) {
		
		System.out.println("pre registrazione " + utente.toString());
		
		ProfiloUtente pU = new ProfiloUtente();
		pU.setIdProfiloUtente(2);
		utente.setProfiloUtente(pU);
		Utente utenteSalvato = null;
		
		utente.setAbilitato(0);
		
		System.out.println("post abilitazione");
		
		
		
		System.out.println("post settaggio id profilo utente e il profilo e' " + utente.getProfiloUtente());
		
		utenteSalvato = serviceUtente.saveUtente(utente);
		System.out.println("post registrazione " + utenteSalvato.toString());
		
		
		return utenteSalvato;
		
	}
	
	@PostMapping(value = "/doLogIn")
    public @ResponseBody Utente checkUtente(@RequestBody Utente utente ) {
		
		
		Utente utenteTrovato = null;
		
		utenteTrovato = serviceUtente.checkUtente(utente);
		
		System.out.println(utenteTrovato);
        return utenteTrovato;
		
    }
	
	@GetMapping(value = "/doListUtenti")
    public @ResponseBody List<Utente> UtenteList() {

		List<Utente> listaUtenti = serviceUtente.getAllUtente();
		
        return listaUtenti;
    }
	
	@PostMapping(value = "/deleteUtente")
	 public @ResponseBody Utente deleteById(@RequestBody Utente utente) {

		serviceUtente.deleteUtente(utente.getIdUtente());
		//System.out.println(user);
		
		return utente;
       
   }
	
	@GetMapping(value = "/recuperaUtente/{idUtente}")
	 public @ResponseBody Utente recuperaCliente(@PathVariable Integer id) {
		
		Utente utenteChecked = serviceUtente.recuperaUtente(id);
		//System.out.println(user);
		
		
		return utenteChecked;
      
  }
	
	@PutMapping(value = "/updateUtente")
	 public @ResponseBody Utente updateUtente(@RequestBody Utente utente) {
		
		Utente utenteUpdated = serviceUtente.saveUtente(utente);
		System.out.println("Utenne update "+utenteUpdated);
		
		
		return utenteUpdated;
     
 }
	
	@PostMapping(value = "/searchUtente")
	 public @ResponseBody List<Utente> search(@RequestBody Utente utente) {
		List <Utente> risultatiRicerca = new ArrayList<>();
		System.out.println("utente arrivato dal fron end " + utente.toString());
		if(!utente.getnomeUtente().equals("") && utente.getEmail().equals("")) {
			risultatiRicerca= serviceUtente.searchByNomeUtente(utente.getnomeUtente());
			System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;
		}
		else if(utente.getnomeUtente().equals("") && !utente.getEmail().equals("")) {
			risultatiRicerca= serviceUtente.searchByEmail(utente.getEmail());
			System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;
		}
		else if(utente.getnomeUtente().equals("") && utente.getEmail().equals("")) {
			risultatiRicerca= serviceUtente.searchByNomeUtenteAndEmail(utente.getnomeUtente(),utente.getEmail());
			System.out.println(risultatiRicerca.toString());
			return risultatiRicerca;
		}
		return risultatiRicerca;
     
 }
	
	

}
