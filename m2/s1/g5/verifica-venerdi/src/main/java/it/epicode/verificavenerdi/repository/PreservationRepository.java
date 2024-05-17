package it.epicode.verificavenerdi.repository;

import it.epicode.verificavenerdi.data.Preservation;
import it.epicode.verificavenerdi.data.User;
import it.epicode.verificavenerdi.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PreservationRepository extends JpaRepository<Preservation, Integer> {
    List<Preservation> findByUserAndDate(User user, LocalDate date);
    boolean existsByWorkstationAndDate(Workstation workstation, LocalDate date);
}
