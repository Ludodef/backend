package it.epicode.esercizio_venerdi.services;

import it.epicode.esercizio_venerdi.entities.Dipendente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DipendenteServices {
    List<Dipendente> getDipendenti();
    Optional<Dipendente> getDipendente(Long id);
    Dipendente save(Dipendente dipendente);
    Optional<Dipendente> update(Long dipendenteId, Dipendente dipendente);
    Optional<Dipendente> delete(Long dipendenteId);
}
