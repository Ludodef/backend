package it.epicode.verificavenerdi.repository;

import it.epicode.verificavenerdi.data.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository <Building, Integer> {
    Building findByCity(String city);
}
