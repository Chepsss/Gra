package it.gm.gestioneRisorseAziendali.Gra.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gm.gestioneRisorseAziendali.Gra.entity.Ruolo;
import it.gm.gestioneRisorseAziendali.Gra.repository.RuoloRepository;

@Service
@Transactional
public class RuoloImpl implements RuoloInterface {
	
	@Autowired
	private RuoloRepository ruoloRepository;

	@Override
	public Ruolo saveRuolo(Ruolo ruolo) {
		Ruolo ruoloSaved = new Ruolo();
		try {
			ruolo.setDataCreazione(LocalDate.now());
			ruoloSaved = ruoloRepository.save(ruolo);
			return ruoloSaved;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ruolo> getAllRuolo() {
		List<Ruolo> listaRuolo= new ArrayList<>();
		try {
			listaRuolo = ruoloRepository.findAll();
			return listaRuolo;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	@Override
	public void deleteRuolo(int idRuolo) {
		ruoloRepository.deleteById(idRuolo);
		
	}

	@Override
	public Ruolo getByIdRuolo(int idRuolo) {
		Ruolo ruoloChecked = new Ruolo();
		try {
			ruoloChecked = ruoloRepository.findById(idRuolo).get();
			return ruoloChecked;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Ruolo updateRuolo(Ruolo ruolo) {
		Ruolo ruoloUpdated = new Ruolo();
		try {
			ruoloUpdated = ruoloRepository.save(ruolo);
			return ruoloUpdated;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
