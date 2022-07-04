package it.gm.gestioneRisorseAziendali.Gra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.gm.gestioneRisorseAziendali.Gra.entity.Ruolo;
import it.gm.gestioneRisorseAziendali.Gra.entity.Ruolo;
import it.gm.gestioneRisorseAziendali.Gra.service.RuoloInterface;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/ruolo")
public class RuoloController {
	
	@Autowired
	private RuoloInterface ruoloService;
	
	@GetMapping(value="/getRuoloMask")
	public ModelAndView getRuoloPage() {
		ModelAndView mv = new ModelAndView("ruoloMask");
		return mv;
	}
	
	@PostMapping(value="/saveRuolo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Ruolo createNewRuolo(@RequestBody Ruolo ruolo) {
		
		Ruolo ruoloSalvato = null;
		
		ruoloSalvato = ruoloService.saveRuolo(ruolo);
		
		return ruoloSalvato;
		
	}
	
	
	@GetMapping(value = "/doRuoloList")
    public @ResponseBody List<Ruolo> getRuoloList() {

		List<Ruolo> listaRuoli = ruoloService.getAllRuolo();
		System.out.println("Lista dei ruoli "+listaRuoli.toString());
        return listaRuoli;
    }
	
	@PostMapping(value = "/deleteRuolo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Ruolo deleteById(@RequestBody Ruolo ruolo) {

		ruoloService.deleteRuolo(ruolo.getIdRuolo());
		//System.out.println(user);
		
		return ruolo;
       
   }
	
	@GetMapping(value = "/recuperaRuolo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Ruolo recuperaRuolo(@RequestBody Ruolo ruolo) {
		
		Ruolo ruoloChecked = ruoloService.getByIdRuolo(ruolo.getIdRuolo());
		//System.out.println(user);
		
		
		return ruoloChecked;
      
  }
	
	@PutMapping(value = "/updateRuolo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Ruolo updateRuolo(@RequestBody Ruolo ruolo) {
		
		Ruolo ruoloUpdated = ruoloService.updateRuolo(ruolo);
		//System.out.println(user);
		
		
		return ruoloUpdated;
     
 }

}
