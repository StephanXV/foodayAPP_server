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


@Service
@Transactional
public class FoodayServiceImpl implements FoodayService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private RistoranteRepository ristoranteRepository;

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
