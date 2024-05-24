package it.epicode.esercizio_venerdi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Dipendente extends BaseEntity {

    @Column(name = "nome",nullable = false)
    private String name;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "email",nullable = false)
    private String email;
    @OneToMany(mappedBy = "worker")
    private List<Dispositivo> devices;
}
