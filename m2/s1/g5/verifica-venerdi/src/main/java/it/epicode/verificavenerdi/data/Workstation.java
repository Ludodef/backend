package it.epicode.verificavenerdi.data;

import jakarta.persistence.*;

public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Workstation typeOfWorkstation;
    private int maxUser;


    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
