package it.epicode.esercizio_venerdi.repositories;

import it.epicode.esercizio_venerdi.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long>, PagingAndSortingRepository<Dipendente, Long> {
}

