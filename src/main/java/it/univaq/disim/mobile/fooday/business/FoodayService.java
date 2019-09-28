package it.univaq.disim.mobile.fooday.business;

import java.util.List;
import java.util.Set;

import it.univaq.disim.mobile.fooday.domain.*;

public interface FoodayService {

	List<Categoria> findAllCategorie() throws BusinessException;

	List<Immagine> findImmaginiByRistoranteId(Long idRistorante) throws BusinessException;

	List<Orario> findOrariByRistoranteId(Long idRistorante) throws BusinessException;

	List<Prenotazione> findPrenotazioniByUtenteId(Long idUtente) throws BusinessException;

	void createPrenotazione(Prenotazione prenotazione) throws BusinessException;

	List<Recensione> findRecensioniByRistoranteId(Long idRistorante) throws BusinessException;

	void createRecensione(Recensione recensione) throws BusinessException;

	List<Ristorante> findRistorantiByCittaNome(String nomeCitta) throws BusinessException;

	List<Ristorante> findRistorantiByNome(String nomeRisto) throws BusinessException;

	List<Ristorante> findRistorantiByUserCity(Long idCitta) throws BusinessException;

	List<Citta> findCittaByNome() throws BusinessException;

	List<Ricerca> findRicercheByUtente(Long idUtente) throws BusinessException;

	List<Ristorante> findRistorantiByCategoryId(Long idCategory) throws BusinessException;

	Ristorante findRistoranteById(Long idRistorante) throws BusinessException;

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Ristorante> findAllRistoranti() throws BusinessException;
}
