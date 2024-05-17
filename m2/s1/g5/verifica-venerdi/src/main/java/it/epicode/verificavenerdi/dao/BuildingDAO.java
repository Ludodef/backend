package it.epicode.verificavenerdi.dao;

import it.epicode.verificavenerdi.data.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDAO extends JpaRepository <Building, Integer> {
}
