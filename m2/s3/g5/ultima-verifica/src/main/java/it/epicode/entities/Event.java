package it.epicode.entities;


import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
public class Event extends BaseEntity{
    private String titolo;
    private String descrizione;
    private String data;
    private String luogo;
    private Integer postiDisponibili;
    private Integer postiPrenotati;
    private boolean disponibilita = true;



}
