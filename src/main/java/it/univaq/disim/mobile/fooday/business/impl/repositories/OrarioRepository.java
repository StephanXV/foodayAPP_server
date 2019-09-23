package it.univaq.disim.mobile.fooday.business.impl.repositories;

import it.univaq.disim.mobile.fooday.domain.Orario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrarioRepository extends JpaRepository<Orario, Long> {

    List<Orario> findOrariByRistoranteId(long idRistorante);
}
