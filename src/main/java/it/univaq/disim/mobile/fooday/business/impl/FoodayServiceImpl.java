package it.univaq.disim.mobile.fooday.business.impl;

import java.util.Date;
import java.util.List;

import it.univaq.disim.mobile.fooday.business.BusinessException;
import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.business.impl.repositories.*;
import it.univaq.disim.mobile.fooday.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class FoodayServiceImpl implements FoodayService {

	@Autowired
	private PasswordEncoder passwordEncoder;

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
    private RicercaRepository ricercaRepository;

	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	public List<Categoria> findAllCategorie() throws BusinessException {
		return categoriaRepository.findAll();
	}

    @Override
    public List<Ricerca> findRicercheByUtente(Long idUtente) throws BusinessException {
        return ricercaRepository.findRicercheByUtenteId(idUtente);
    }


    @Override
	public List<Immagine> findImmaginiByRistoranteId(Long idRistorante) throws BusinessException {
		return immagineRepository.findImmaginiByRistoranteId(idRistorante);
	}

	@Override
	public List<Orario> findOrariByRistoranteId(Long idRistorante) throws BusinessException {
		return orarioRepository.findOrariByRistoranteId(idRistorante);
	}

	@Override
	public List<Prenotazione> findPrenotazioniByUtenteId(Long idUtente) throws BusinessException {
		return prenotazioneRepository.findPrenotazioniByUtenteId(idUtente);
	}

	@Override
	public Prenotazione createPrenotazione(Prenotazione prenotazione) throws BusinessException {
		Prenotazione newPrenotazione = new Prenotazione();
		PrenotazioneId prenotazioneId = new PrenotazioneId(prenotazione.getRistorante(), prenotazione.getUtente(),
				System.currentTimeMillis());
		newPrenotazione.setPrenotazioneId(prenotazioneId);
		newPrenotazione.setPosti(prenotazione.getPosti());
		newPrenotazione.setGiorno(prenotazione.getGiorno());
		newPrenotazione.setOrario(prenotazione.getOrario());
		newPrenotazione.setScontoApplicato(prenotazione.getScontoApplicato());
		newPrenotazione.setNome(prenotazione.getNome());
		newPrenotazione.setUsaPunti(prenotazione.isUsaPunti());
		prenotazioneRepository.save(newPrenotazione);
		return  newPrenotazione;
	}

	@Override
	public List<Recensione> findRecensioniByRistoranteId(Long idRistorante) throws BusinessException {
		return null;
	}

	@Override
	public Recensione createRecensione(Recensione recensione) throws BusinessException {
		Recensione newRecensione = new Recensione();
		RecensioneId recensioneId = new RecensioneId(recensione.getRistorante(), recensione.getUtente(), System.currentTimeMillis());
		newRecensione.setRecensioneId(recensioneId);
		newRecensione.setVotoCucina(recensione.getVotoCucina());
		newRecensione.setVotoServizio(recensione.getVotoServizio());
		newRecensione.setVotoPrezzo(recensione.getVotoPrezzo());
		newRecensione.setDescrizione(recensione.getDescrizione());
		recensioneRepository.save(newRecensione);
		return newRecensione;
	}

	@Override
	public List<Ristorante> findRistorantiByCittaNome(String nomeCitta) throws BusinessException {
		return ristoranteRepository.findRistorantiByCittaNome(nomeCitta);
	}

	@Override
	public List<Ristorante> findRistorantiByNome(String nomeRisto) throws BusinessException {
		return ristoranteRepository.findRistorantiByNomeContaining(nomeRisto);
	}

	@Override
	public List<Ristorante> findRistorantiByUserCity(Long idCitta) throws BusinessException {
		return ristoranteRepository.findRistorantiByCittaId(idCitta);
	}

	@Override
	public List<Ristorante> findRistorantiByCategoryId(Long idCategoria) throws BusinessException {
		return ristoranteRepository.findRistorantiByCategorieId(idCategoria);
	}

	@Override
	public Ristorante findRistoranteById(Long idRistorante) throws BusinessException {
		return ristoranteRepository.findById(idRistorante).get();
	}

	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}

	@Override
    public Categoria findCategoriaById(long categoriaId) throws  BusinessException {
	    return categoriaRepository.findById(categoriaId).get();
    }

	@Override
	public List<Ristorante> findAllRistoranti() throws BusinessException {
		return ristoranteRepository.findAll();
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Citta citta = new Citta();
		if (cittaRepository.findByNome(profilo.getCitta().getNome()) != null)
			citta = cittaRepository.findByNome(profilo.getCitta().getNome());
		else {
			citta.setNome(profilo.getCitta().getNome());
			cittaRepository.save(citta);
		}
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setNome(profilo.getNome());
		utente.setCognome(profilo.getCognome());
		utente.setUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		if (profilo.getPassword() != null)
			utente.setPassword(passwordEncoder.encode(profilo.getPassword()));
		utente.setTelefono(profilo.getTelefono());
		utente.setNascita(profilo.getNascita());
		utente.setCitta(citta);
		utente.setSesso(profilo.getSesso());
		return utente;
	}

	@Override
	public Citta findCitta(String nome) {
		return cittaRepository.findByNome(nome);
	}

	@Override
	public List<Ristorante> findRistorantiPreferiti(Long idUtente) {
		return ristoranteRepository.findRistorantiByPreferitiId(idUtente);
	}

	@Override
	public void deleteRistoranteByPreferiti(long idRistorante, long idUtente) {
		utenteRepository.getOne(idUtente).getPreferiti().remove(ristoranteRepository.getOne(idRistorante));
	}

	@Override
	public Utente registerUtente(Utente nuovoUtente) {
		Citta citta = new Citta();
		if (cittaRepository.findByNome(nuovoUtente.getCitta().getNome()) != null)
			citta = cittaRepository.findByNome(nuovoUtente.getCitta().getNome());
		else {
			citta.setNome(nuovoUtente.getCitta().getNome());
			cittaRepository.save(citta);
		}
		Utente utente = new Utente(nuovoUtente.getNome(), nuovoUtente.getCognome(),
				nuovoUtente.getUsername(), passwordEncoder.encode(nuovoUtente.getPassword()), nuovoUtente.getEmail(),
				nuovoUtente.getSesso(),	nuovoUtente.getTelefono(), nuovoUtente.getNascita(),
				"assets/images/profilo.jpg", citta, 0);
		utenteRepository.save(utente);
		return utente;
	}

	@Override
	public int deletePrenotazione(long idUtente, long idRistorante, long timestamp) {
		int i = prenotazioneRepository.deletePrenotazione(idRistorante, idUtente, timestamp);
		return i;
	}

    @Override
    public int prenotazioneValutata(long idUtente, long idRistorante, long timestamp) {
	    Utente utente = utenteRepository.findById(idUtente).get();
	    Ristorante ristorante = ristoranteRepository.findById(idRistorante).get();
        Prenotazione prenotazione = this.prenotazioneRepository.findById(new PrenotazioneId(ristorante, utente, timestamp)).get();
        prenotazione.setValutata(true);
        return 1;
    }
}

