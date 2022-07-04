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


import it.gm.gestioneRisorseAziendali.Gra.entity.SocietaCollaborazione;
import it.gm.gestioneRisorseAziendali.Gra.service.SocietaCollaborazioneInterface;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/societaColl")
public class SocietaCollaborazioneController {
	
	@Autowired
	private SocietaCollaborazioneInterface serviceSocietaColl;
	
	
	
	
	@PostMapping(value="/saveSocColl")
	public @ResponseBody SocietaCollaborazione createNewSocCollab(@RequestBody SocietaCollaborazione sc) {
		
		SocietaCollaborazione socSaved = null;
		
		socSaved = serviceSocietaColl.saveSocietaCollaborazione(sc);
		
		return socSaved;
		
	}
	
	@GetMapping(value = "/doListSocCollab")
    public @ResponseBody List<SocietaCollaborazione> getSocCollList() {

		List<SocietaCollaborazione> listaSocieta = serviceSocietaColl.getAllSocietaCollaborazione();
		System.out.println("Lista societa dal controller "+listaSocieta);
        return listaSocieta;
    }
	
	@PostMapping(value = "/deleteSocColl")
	 public @ResponseBody SocietaCollaborazione deleteById(@RequestBody SocietaCollaborazione sc) {

		serviceSocietaColl.deleteSocietaCollaborazione(sc.getIdsocietacollaborazione());
		//System.out.println(user);
		
		return sc;
       
   }
	
	@PostMapping(value = "/recuperaSocColl", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody SocietaCollaborazione recuperaSocColl(@RequestBody SocietaCollaborazione sc) {
		
		SocietaCollaborazione socCollChecked = serviceSocietaColl.getByIdRSocietaCollaborazione(sc.getIdsocietacollaborazione());
		//System.out.println(user);
		
		     
		return socCollChecked;
      
  }
	

	@PostMapping(value = "/recuperaSocCollByNome")
	 public @ResponseBody SocietaCollaborazione recuperaSocCollByNome(@RequestBody SocietaCollaborazione sc) {
		
		System.out.println("Parametro metodo contorller  "+sc);
		System.out.println("Parametro metodo get socCol  "+sc.getTipologiaCollaborazione());
		SocietaCollaborazione socCollChecked = serviceSocietaColl.getByTipologiaCollaborazione(sc.getTipologiaCollaborazione());
		System.out.println("Societa recuperata "+socCollChecked);
		
		     
		return socCollChecked;
      
  }
	
	@PutMapping(value = "/updateSocColl")
	 public @ResponseBody SocietaCollaborazione updateSocColl(@RequestBody SocietaCollaborazione sc) {
		
		SocietaCollaborazione socCollUpdated = serviceSocietaColl.updateSocietaCollaborazione(sc);
		//System.out.println(user);
		
		
		return socCollUpdated;
     
 }


}
