package it.univaq.disim.mobile.fooday.business.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univaq.disim.mobile.fooday.domain.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);
}
