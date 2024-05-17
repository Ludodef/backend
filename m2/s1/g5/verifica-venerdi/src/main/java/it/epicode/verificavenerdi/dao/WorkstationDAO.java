package it.epicode.verificavenerdi.dao;

import it.epicode.verificavenerdi.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkstationDAO extends JpaRepository<Workstation,Integer> {
    List<WorkstationDAO> findByTypeAndBuilding(String type, String building);
}
