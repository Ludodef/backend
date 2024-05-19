package it.epicode.verificavenerdi.runner;

import it.epicode.verificavenerdi.data.Building;
import it.epicode.verificavenerdi.data.Type;
import it.epicode.verificavenerdi.data.User;
import it.epicode.verificavenerdi.data.Workstation;
import it.epicode.verificavenerdi.repository.BuildingRepository;
import it.epicode.verificavenerdi.repository.PreservationRepository;
import it.epicode.verificavenerdi.repository.UserRepository;
import it.epicode.verificavenerdi.repository.WorkstationRepository;
import it.epicode.verificavenerdi.service.PreservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class Runner implements CommandLineRunner {
    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;
    private final WorkstationRepository workstationRepository;
    private final PreservationRepository preservationRepository;
    private final PreservationService preservationService;

    @Autowired
    public Runner(BuildingRepository buildingRepository, UserRepository userRepository, WorkstationRepository workstationRepository, PreservationRepository preservationRepository, PreservationService preservationService) {
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
        this.workstationRepository = workstationRepository;
        this.preservationRepository = preservationRepository;
        this.preservationService = preservationService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            Building building0 = Building.builder()
                    .withName("La rosa nel bicchiere")
                   .withAddress("Localita polso")
                    .withCity("Soveria Mannelli")
                   .build();

            Building building1 = Building.builder()
                    .withName("Palahotel Vallenoce")
                   .withAddress("Contrada Vallenoce")
                    .withCity("Decollatura")
                   .build();
            Building building2 = Building.builder()
                    .withName("Da Gianluca pizzeria")
                   .withAddress("Via Stazione")
                    .withCity("Colosimi")
                   .build();
            User user0 = User.builder()
                    .withId(1L)
                    .withName("Ludovica De Fazio")
                    .withUsername("1")
                    .withEmail("ludo@def.it")
                   .build();
            User user1 = User.builder()
                    .withId(2L)
                    .withName("Domenico De Fazio")
                    .withUsername("2")
                    .withEmail("dome@def.it")
                   .build();
            User user2 = User.builder()
                    .withId(3L)
                    .withName("Jacopo De Fazio")
                    .withUsername("3")
                    .withEmail("jacopo@def.it")
                   .build();
            User user3 = User.builder()
                    .withId(4L)
                    .withName("Rita Bevilacqua")
                    .withUsername("4")
                    .withEmail("rita@bevi.it")
                   .build();
            Workstation workstation1 = Workstation.builder()
                    .withId(1L)
                    .withBuilding(building0)
                    .withDescription("Sala per le feste")
                    .withMaxUser(50)
                    .withType(Type.PRIVATE)
                    .build();
            Workstation workstation2 = Workstation.builder()
                    .withId(2L)
                    .withBuilding(building1)
                    .withDescription("Sala per le grandi occasioni")
                    .withMaxUser(150)
                    .withType(Type.OPEN_SPACE)
                    .build();
            Workstation workstation3 = Workstation.builder()
                    .withId(3L)
                    .withBuilding(building1)
                    .withDescription("Sala per le riunioni")
                    .withMaxUser(10)
                    .withType(Type.MEETING_ROOM)
                    .build();

            buildingRepository.save(building0);
            buildingRepository.save(building1);
            buildingRepository.save(building2);
            userRepository.save(user0);
            userRepository.save(user1);
            userRepository.save(user2);
            workstationRepository.save(workstation1);
            workstationRepository.save(workstation2);
            workstationRepository.save(workstation3);



            System.out.println("Edifici salvati correttamente");
            System.out.println("User salvati correttamente");
            System.out.println("Postazioni salvate correttamente");


        }catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("basta");
        }
    }
}
