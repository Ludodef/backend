package it.epicode.verificavenerdi.service;

import it.epicode.verificavenerdi.data.Building;
import it.epicode.verificavenerdi.data.Type;
import it.epicode.verificavenerdi.data.Workstation;
import it.epicode.verificavenerdi.repository.BuildingRepository;
import it.epicode.verificavenerdi.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WorkstationService {
    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    public Workstation findById(Long id) {
        Optional<Workstation> workstationOptional = workstationRepository.findById(id);
        return workstationOptional.orElse(null);
    }

    public List<Workstation> findByTypeOfWorkStationAndBuilding(Type type, String city) {
        Building building = buildingRepository.findByCity(city);

        if (building != null) {
            return workstationRepository.findByTypeAndBuilding(type, building);
        } else {
            return Collections.emptyList();
        }
    }
}
