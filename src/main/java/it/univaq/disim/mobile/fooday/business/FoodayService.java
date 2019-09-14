package it.univaq.disim.mobile.fooday.business;

import java.util.List;

import it.univaq.disim.mobile.fooday.domain.*;

public interface FoodayService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Notizia> findAllNotizie() throws BusinessException;

	List<Prenotazione> findAllPrenotazioni(Utente utente) throws BusinessException;

	Notizia findNotiziaById(Long id) throws BusinessException;

	List<Insegnamento> findAllInsegnamenti(Utente utente) throws BusinessException;

	List<Appello> findAllAppelli(long idInsegnamento) throws BusinessException;

	void createAppello(Appello appello) throws BusinessException;

	Appello findAppelloById(long idAppello) throws BusinessException;

	void updateAppello(Appello appello) throws BusinessException;

	void deleteAppello(long idAppello) throws BusinessException;

}
