package it.univaq.disim.mobile.fooday.business.impl.repositories;

import it.univaq.disim.mobile.fooday.domain.Prenotazione;
import it.univaq.disim.mobile.fooday.domain.PrenotazioneId;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, PrenotazioneId> {

    List<Prenotazione> findPrenotazioniByUtenteId(long idUtente);

    @Modifying
    @Query(value = "delete from prenotazioni where id_ristorante = ?1 and id_utente = ?2",
            nativeQuery=true)
    int deletePrenotazione(long idRistorante, long idUtente);

}
