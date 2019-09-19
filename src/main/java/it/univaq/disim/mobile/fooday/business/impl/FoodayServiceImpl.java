package it.univaq.disim.mobile.fooday.business.impl;

import java.util.List;

import it.univaq.disim.mobile.fooday.business.BusinessException;
import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.business.impl.repositories.*;
import it.univaq.disim.mobile.fooday.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;


@Service
@Transactional
public class FoodayServiceImpl implements FoodayService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CittaRepository cittaRepository;

	@Autowired
	private ImmagineRepository immagineRepository;

	@Autowired
	private OrarioRepository orarioRepository;

	@Autowired
	private PietanzaRepository pietanzaRepository;

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	@Autowired
	private RecensioneRepository recensioneRepository;

	@Autowired
	private RistoranteRepository ristoranteRepository;

	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	public List<Categoria> findAllCategorie() throws BusinessException {
		return categoriaRepository.findAll();
	}

	@Override
	public List<Immagine> findImmaginiByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public List<Orario> findOrariByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public List<Pietanza> findAntipastiByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public List<Pietanza> findPrimiByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public List<Pietanza> findSecondiByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public List<Pietanza> findDessertsByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public List<Pietanza> findBevandeByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public List<Prenotazione> findPrenotazioniByUtenteId(Long idUtente) throws BusinessException {
		return null;
	}

	@Override
	public void createPrenotazione(Prenotazione prenotazione) throws BusinessException {

	}

	@Override
	public List<Recensione> findRecensioniByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public void createRecensione(Recensione recensione) throws BusinessException {

	}

	@Override
	public List<Ristorante> findRistorantiByStringInput(String input) throws BusinessException {
		return null;
	}

	@Override
	public List<Ristorante> findRistorantiByLocationInput(Long idCitta) throws BusinessException {
		return ristoranteRepository.findRistorantiByCittaId(idCitta);
	}

	@Override
	public List<Ristorante> findRistorantiByCategoryId(Long idCategory) throws BusinessException {
		return null;
	}

	@Override
	public Ristorante findRistoranteById(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}
	@Override
	public List<Ristorante> findAllRistoranti() throws BusinessException {
		return ristoranteRepository.findAll();
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		utente.setTelefono(profilo.getTelefono());
		return utente;
	}
}
