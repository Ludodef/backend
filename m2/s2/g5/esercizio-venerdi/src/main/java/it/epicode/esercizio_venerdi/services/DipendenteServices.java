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
    Dipendente update(Long dipendenteId, Dipendente dipendente);
    Dipendente delete(Long dipendenteId);
}
