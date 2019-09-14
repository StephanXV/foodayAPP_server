package it.univaq.disim.mobile.fooday.business.impl.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import it.univaq.disim.mobile.fooday.domain.Insegnamento;

public interface InsegnamentoRepository extends JpaRepository<Insegnamento, Long>{

	List<Insegnamento> findInsegnamentiByDocenteId(Long idDocente, Sort sort);

}
