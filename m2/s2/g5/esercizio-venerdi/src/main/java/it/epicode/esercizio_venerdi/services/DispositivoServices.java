package it.epicode.esercizio_venerdi.services;

import it.epicode.esercizio_venerdi.entities.Dispositivo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DispositivoServices {
    List<Dispositivo> getDispositivi();
    Optional<Dispositivo> getDispositivo(Long id);
    Dispositivo save(Dispositivo dispositivo);
    Optional<Dispositivo> update(Long dispositivoId, Dispositivo dispositivo);
    Optional<Dispositivo> delete(Long dispositivoId);
    Dispositivo assegna(Long dispositivoId, Long dipendenteId);
    Dispositivo rimuovi(Long dispositivoId, Long dipendenteId);

}
