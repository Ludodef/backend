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
import java.util.List;

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
    public boolean isUserAlreadyReserved(User user, LocalDate dateReservation){
        return preservationRepository.existsByUserAndDate(user, dateReservation);
    }

    public boolean isWorkstationAvailable(Workstation workstation, LocalDate dateReservation){
        return !preservationRepository.existsByWorkstationAndDate(workstation, dateReservation);
    }

    public List<Preservation> reservationsByUserAndDate(User user, LocalDate dateReservation){
        return preservationRepository.findByUserAndDate(user, dateReservation);
    }
}
