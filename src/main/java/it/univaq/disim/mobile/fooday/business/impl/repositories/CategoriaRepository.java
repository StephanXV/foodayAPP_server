package it.univaq.disim.mobile.fooday.business.impl.repositories;

import it.univaq.disim.mobile.fooday.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
