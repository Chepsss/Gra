package it.gm.gestioneRisorseAziendali.Gra.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gm.gestioneRisorseAziendali.Gra.entity.SocietaCollaborazione;
import it.gm.gestioneRisorseAziendali.Gra.entity.Utente;
import it.gm.gestioneRisorseAziendali.Gra.repository.UtenteRepository;

@Service
@Transactional
public class UtenteImpl implements UtenteInterface{
	
	@Autowired
	private UtenteRepository repository;

	@Override
	public Utente saveUtente(Utente utente) {
		Utente utenteSalvato = new Utente();
		
		try {
			utenteSalvato.setAbilitato(0);
			utenteSalvato = repository.save(utente);
			return utenteSalvato;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Utente checkUtente(Utente utente) {
		Utente utenteChecked = new Utente();
		
		try {
			utenteChecked = repository.findByEmailAndPassword(utente.getEmail(), utente.getPassword());
			return utenteChecked;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Utente> getAllUtente() {
		List <Utente> listaUtenti = new ArrayList<>();
		try {
			listaUtenti = repository.findAll();
			return listaUtenti;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteUtente(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Utente recuperaUtente(int id) {
		Utente utente = new Utente ();
		try {
			utente = repository.findById(id).get();
			return utente;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Utente updateUtente(Utente utente) {
	Utente utenteAggiornato = new Utente();
		
		try {
			utenteAggiornato = repository.save(utente);
			return utenteAggiornato;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Utente> searchByNomeUtente(String nome) {
		List <Utente> listaUtentiByNome = new ArrayList<>();
		try {
			listaUtentiByNome = repository.findByNomeUtenteAllIgnoreCaseStartingWith(nome);
			return listaUtentiByNome;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Utente> searchByEmail(String email) {
		List <Utente> listaUtentiByEmail = new ArrayList<>();
		try {
			listaUtentiByEmail = repository.findByEmailAllIgnoreCaseStartingWith(email);
			return listaUtentiByEmail;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Utente> searchBySocietaCollaborazione(SocietaCollaborazione sC) {
		List <Utente> listaUtentiBySocColl = new ArrayList<>();
		try {
			listaUtentiBySocColl = repository.findAll();
			return listaUtentiBySocColl;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Utente> searchByNomeUtenteAndEmail(String nomeUtente, String email) {
		List <Utente> listaUtentiByEmail = new ArrayList<>();
		try {
			listaUtentiByEmail = repository.findByEmailAllIgnoreCaseStartingWith(email);
			return listaUtentiByEmail;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}
