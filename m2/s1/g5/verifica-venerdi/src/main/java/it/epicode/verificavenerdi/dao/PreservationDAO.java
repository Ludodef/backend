package it.epicode.verificavenerdi.dao;

import it.epicode.verificavenerdi.data.Preservation;
import it.epicode.verificavenerdi.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PreservationDAO extends JpaRepository<Preservation, Integer> {
    List<PreservationDAO> findByUserAndDate(String user, LocalDate date);
    boolean existsByWorkstationAndDate(Workstation workstation, LocalDate date);
}
