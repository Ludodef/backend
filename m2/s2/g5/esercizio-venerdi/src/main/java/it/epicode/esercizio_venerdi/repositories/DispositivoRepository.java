package it.epicode.esercizio_venerdi.repositories;

import it.epicode.esercizio_venerdi.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long>, PagingAndSortingRepository<Dispositivo ,Long> {
}
