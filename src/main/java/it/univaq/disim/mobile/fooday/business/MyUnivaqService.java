package it.univaq.disim.mobile.fooday.business;

import java.util.List;

import it.univaq.disim.mobile.fooday.domain.Appello;
import it.univaq.disim.mobile.fooday.domain.Insegnamento;
import it.univaq.disim.mobile.fooday.domain.Notizia;
import it.univaq.disim.mobile.fooday.domain.Utente;

public interface MyUnivaqService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Notizia> findAllNotizie() throws BusinessException;

	Notizia findNotiziaById(Long id) throws BusinessException;

	List<Insegnamento> findAllInsegnamenti(Utente utente) throws BusinessException;

	List<Appello> findAllAppelli(long idInsegnamento) throws BusinessException;

	void createAppello(Appello appello) throws BusinessException;

	Appello findAppelloById(long idAppello) throws BusinessException;

	void updateAppello(Appello appello) throws BusinessException;

	void deleteAppello(long idAppello) throws BusinessException;

}
