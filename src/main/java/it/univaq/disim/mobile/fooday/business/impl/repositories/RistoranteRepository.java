package it.univaq.disim.mobile.fooday.business.impl.repositories;

import it.univaq.disim.mobile.fooday.domain.Citta;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RistoranteRepository extends JpaRepository<Ristorante, Long>{

    List<Ristorante> findRistorantiByCittaId(long idCitta);

    List<Ristorante> findRistorantiByCategorieId(long idCategoria);
}
