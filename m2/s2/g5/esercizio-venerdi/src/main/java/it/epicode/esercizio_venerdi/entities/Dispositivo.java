package it.epicode.esercizio_venerdi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dispositivo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Dispositivo extends BaseEntities {
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Dipendente dipendente;
}
