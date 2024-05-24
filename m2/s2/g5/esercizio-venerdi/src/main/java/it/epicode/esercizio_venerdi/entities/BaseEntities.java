package it.epicode.esercizio_venerdi.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

public class BaseEntities {
    @Data
    @MappedSuperclass

    public static class BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
    }
}
