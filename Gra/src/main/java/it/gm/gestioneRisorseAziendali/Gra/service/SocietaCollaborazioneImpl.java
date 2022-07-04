package it.gm.gestioneRisorseAziendali.Gra.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.gm.gestioneRisorseAziendali.Gra.entity.SocietaCollaborazione;
import it.gm.gestioneRisorseAziendali.Gra.repository.SocietaCollaborazioneRepository;

@Service
@Transactional
public class SocietaCollaborazioneImpl implements SocietaCollaborazioneInterface {
	
	@Autowired
	SocietaCollaborazioneRepository repository;

	@Override
	public SocietaCollaborazione saveSocietaCollaborazione(SocietaCollaborazione sc) {
		
		SocietaCollaborazione scSaved = new SocietaCollaborazione();
		
		try {
			scSaved=repository.save(sc);
			return scSaved;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public List<SocietaCollaborazione> getAllSocietaCollaborazione() {
List<SocietaCollaborazione> listaSocietaColl = new ArrayList<>();
		
		try {
			listaSocietaColl = repository.findAll();
			System.out.println("dal Service "+listaSocietaColl);
			return listaSocietaColl;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteSocietaCollaborazione(int idSocColl) {
		repository.deleteById(idSocColl);
		
	}

	@Override
	public SocietaCollaborazione getByIdRSocietaCollaborazione(int idSocColl) {

		SocietaCollaborazione scChecked = new SocietaCollaborazione();
		
		try {
			scChecked=repository.findById(idSocColl).get();
			return scChecked;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public SocietaCollaborazione getByTipologiaCollaborazione(String tipologiaCollaborazione) {

	SocietaCollaborazione soc = new SocietaCollaborazione();
		
		try {
			System.out.println("Parametrno tipologiaSocieta Soc "+tipologiaCollaborazione);
			soc=repository.findByTipologiaCollaborazione(tipologiaCollaborazione);
			System.out.println("Oggetto Soc in implements " + soc);
			return soc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public SocietaCollaborazione updateSocietaCollaborazione(SocietaCollaborazione sc) {
	SocietaCollaborazione scUpdated = new SocietaCollaborazione();
		
		try {
			scUpdated=repository.save(sc);
			return scUpdated;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}


}
