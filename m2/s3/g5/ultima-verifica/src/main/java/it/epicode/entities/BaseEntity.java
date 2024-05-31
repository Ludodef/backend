package it.epicode.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
}
