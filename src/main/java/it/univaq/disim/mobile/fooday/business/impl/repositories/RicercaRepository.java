package it.univaq.disim.mobile.fooday.business.impl.repositories;

import it.univaq.disim.mobile.fooday.domain.Ricerca;
import org.springframework.data.jpa.repository.JpaRepository;

import it.univaq.disim.mobile.fooday.domain.Utente;

import java.util.List;

public interface RicercaRepository extends JpaRepository<Ricerca, Long> {

    List<Ricerca> findRicercheByUtenteId(long IdUtente);
}
