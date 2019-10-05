package it.univaq.disim.mobile.fooday.business;

import java.util.List;

import it.univaq.disim.mobile.fooday.domain.*;

public interface FoodayService {

	List<Categoria> findAllCategorie() throws BusinessException;

	List<Immagine> findImmaginiByRistoranteId(Long idRistorante) throws BusinessException;

	List<Orario> findOrariByRistoranteId(Long idRistorante) throws BusinessException;

	List<Prenotazione> findPrenotazioniByUtenteId(Long idUtente) throws BusinessException;

	Prenotazione createPrenotazione(Prenotazione prenotazione) throws BusinessException;

	List<Recensione> findRecensioniByRistoranteId(Long idRistorante) throws BusinessException;

	Recensione createRecensione(Recensione recensione) throws BusinessException;

	List<Ristorante> findRistorantiByCittaNome(String nomeCitta) throws BusinessException;

	List<Ristorante> findRistorantiByNome(String nomeRisto) throws BusinessException;

	List<Ristorante> findRistorantiByUserCity(Long idCitta) throws BusinessException;

	List<Ricerca> findRicercheByUtente(Long idUtente) throws BusinessException;

	List<Ristorante> findRistorantiByCategoryId(Long idCategory) throws BusinessException;

	Ristorante findRistoranteById(Long idRistorante) throws BusinessException;

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Ristorante> findAllRistoranti() throws BusinessException;

	List<Ristorante> findRistorantiPreferiti(Long idUtente);

	void deleteRistoranteByPreferiti(long idRistorante, long idUtente);

	Utente registerUtente(Utente nuovoUtente);

	Citta findCitta(String nome);

	int deletePrenotazione(long ristoranteId, long utenteId, long timestamp);

	int prenotazioneValutata(long utenteId, long ristoranteId, long timestamp);

	Categoria findCategoriaById(long categoriaId);
}
