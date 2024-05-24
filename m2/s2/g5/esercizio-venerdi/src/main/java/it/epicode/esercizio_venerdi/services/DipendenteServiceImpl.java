package it.epicode.esercizio_venerdi.services;

import it.epicode.esercizio_venerdi.entities.Dipendente;
import it.epicode.esercizio_venerdi.repositories.DipendenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class DipendenteServiceImpl implements DipendenteServices {

    @Autowired
    DipendenteRepository dipendenti;

    @Override
    public List<Dipendente> getDipendenti() {
        return dipendenti.findAll();
    }

    @Override
    public Optional<Dipendente> getDipendente(Long id) {
        try{
        return dipendenti.findById(id);
        }catch(Exception ex){
            log.error(String.format("Nessun id trovato"),ex);
            return  Optional.empty();
        }

    }

    @Override
    public Dipendente save(Dipendente dipendente) {
        try{
            return dipendenti.save(dipendente);
        }catch (Exception ex){
            log.error(String.format("Nessun salavataggio.Riprova"),ex);
            return  null;
        }
    }

    @Override
    public Optional<Dipendente> update(Long dipendenteId, Dipendente dipendente) {
        try{
            var d = dipendenti.findById(dipendenteId).orElseThrow();
            d.builder()
                    .withName(d.getName())
                    .withSurname(d.getSurname())
                    .withUsername(d.getUsername())
                    .withEmail(d.getEmail())
                    .withDevices(d.getDevices())
                    .build();
            return Optional.of(dipendenti.save(d));


        }catch (NoSuchElementException ex){
            log.error(String.format("Non sei riuscito ad aggiornare"),ex);

        }
        return  Optional.empty();
    }

    @Override
    public Optional<Dipendente> delete(Long dipendenteId) {
        try{
            var d = dipendenti.findById(dipendenteId).orElseThrow();
            dipendenti.delete(d);
            return Optional.of(d);
        }catch (NoSuchElementException ex){
            log.error(String.format("Non sei riuscito a eliminare"),ex);
            throw new RuntimeException("Dipendente non trovato");
        }catch(Exception ex){
            log.error(String.format("Non sei riuscito a eliminare"));
            throw new RuntimeException();

        }
    }
}
