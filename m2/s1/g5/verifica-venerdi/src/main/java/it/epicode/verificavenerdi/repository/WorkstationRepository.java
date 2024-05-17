package it.epicode.verificavenerdi.repository;

import it.epicode.verificavenerdi.data.Building;
import it.epicode.verificavenerdi.data.Type;
import it.epicode.verificavenerdi.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation,Integer> {
    List<Workstation> findByTypeAndBuilding(Type type, Building building);
}
