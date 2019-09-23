package it.univaq.disim.mobile.fooday.business.impl.repositories;

import it.univaq.disim.mobile.fooday.domain.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findPrenotazioniByUtenteId(long idUtente);
}
