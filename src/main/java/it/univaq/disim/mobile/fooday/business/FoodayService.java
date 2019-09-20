package it.univaq.disim.mobile.fooday.business;

import java.util.List;
import java.util.Set;

import it.univaq.disim.mobile.fooday.domain.*;

public interface FoodayService {

	List<Categoria> findAllCategorie() throws BusinessException;

	List<Immagine> findImmaginiByRistoranteId(Long idRistorante) throws BusinessException;

	List<Orario> findOrariByRistoranteId(Long idRistorante) throws BusinessException;

	List<Pietanza> findAntipastiByRistoranteId(Long idRistorante) throws BusinessException;

	List<Pietanza> findPrimiByRistoranteId(Long idRistorante) throws BusinessException;

	List<Pietanza> findSecondiByRistoranteId(Long idRistorante) throws BusinessException;

	List<Pietanza> findDessertsByRistoranteId(Long idRistorante) throws BusinessException;

	List<Pietanza> findBevandeByRistoranteId(Long idRistorante) throws BusinessException;

	List<Prenotazione> findPrenotazioniByUtenteId(Long idUtente) throws BusinessException;

	void createPrenotazione(Prenotazione prenotazione) throws BusinessException;

	List<Recensione> findRecensioniByRistoranteId(Long idRistorante) throws BusinessException;

	void createRecensione(Recensione recensione) throws BusinessException;

	List<Ristorante> findRistorantiByStringInput(String input) throws BusinessException;

	List<Ristorante> findRistorantiByUserCity(Long idCitta) throws BusinessException;

	List<Citta> findCittaByNome() throws BusinessException;

	List<Ristorante> findRistorantiByCategoryId(Long idCategory) throws BusinessException;

	Ristorante findRistoranteById(Long idRistorante) throws BusinessException;

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Ristorante> findAllRistoranti() throws BusinessException;
}
