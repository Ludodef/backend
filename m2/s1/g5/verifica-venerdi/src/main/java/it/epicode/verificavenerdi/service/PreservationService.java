package it.epicode.verificavenerdi.service;


import it.epicode.verificavenerdi.data.Preservation;
import it.epicode.verificavenerdi.data.User;
import it.epicode.verificavenerdi.data.Workstation;
import it.epicode.verificavenerdi.repository.PreservationRepository;
import it.epicode.verificavenerdi.repository.UserRepository;
import it.epicode.verificavenerdi.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PreservationService {
    @Autowired
    private PreservationRepository preservationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkstationRepository workstationRepository;

    public PreservationRepository createReservation(String username, Long workstationId, LocalDate date){
        User user = userRepository.findById(Integer.valueOf(username))
                .orElseThrow(()-> new RuntimeException("User not find") );
        Workstation workstation = workstationRepository.findById(Math.toIntExact(workstationId))
                .orElseThrow(() -> new RuntimeException("Workstation not found"));

        Preservation preservation = new Preservation();
        preservation.setUser(user);
        preservation.setWorkstation(workstation);
        preservation.setDate(date);

        return(PreservationRepository) preservationRepository.save(preservation);
    }
}
