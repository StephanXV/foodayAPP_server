package it.univaq.disim.mobile.fooday.business.impl.repositories;

import it.univaq.disim.mobile.fooday.domain.Immagine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImmagineRepository extends JpaRepository<Immagine, Long> {

    List<Immagine> findImmaginiByRistoranteId(long idRistorante);
}
