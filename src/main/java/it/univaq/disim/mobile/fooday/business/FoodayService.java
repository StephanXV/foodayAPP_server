package it.univaq.disim.mobile.fooday.business;

import java.util.List;

import it.univaq.disim.mobile.fooday.domain.*;

public interface FoodayService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Ristorante> findAllRistoranti() throws BusinessException;
}
