package it.epicode.esercizio_venerdi.services;

import it.epicode.esercizio_venerdi.entities.DeviceStatus;
import it.epicode.esercizio_venerdi.entities.Dispositivo;
import it.epicode.esercizio_venerdi.repositories.DipendenteRepository;
import it.epicode.esercizio_venerdi.repositories.DispositivoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class DispositivoServiceImpl implements DispositivoServices{

    @Autowired
    DispositivoRepository dispositivi;
    @Autowired
    DipendenteRepository dipendenti;

    @Override
    public List<Dispositivo> getDispositivi() {
        return dispositivi.findAll();
    }

    @Override
    public Optional<Dispositivo> getDispositivo(Long id) {
        try{
            return dispositivi.findById(id);
        }catch(Exception ex){
            log.error(String.format("Nessun id trovato"),ex);
            return  Optional.empty();
        }
    }

    @Override
    public Dispositivo save(Dispositivo dispositivo) {
        try{
            return dispositivi.save(dispositivo);
        }catch (Exception ex){
            log.error(String.format("Nessun salavataggio.Riprova"),ex);
            return  null;
        }
    }

    @Override
    public Optional<Dispositivo> update(Long dispositivoId, Dispositivo dispositivo) {
        try{
            var d = dispositivi.findById(dispositivoId).orElseThrow();
            d.builder()
                    .withDeviceStatus(d.getDeviceStatus())
                    .withDeviceType(d.getDeviceType())
                    .withDipendente(d.getDipendente())
                    .build();
            return Optional.of(dispositivi.save(d));


        }catch (NoSuchElementException ex){
            log.error(String.format("Non sei riuscito ad aggiornare"),ex);

        }
        return  Optional.empty();
    }

    @Override
    public Optional<Dispositivo> delete(Long dispositivoId) {
        try{
            var d = dispositivi.findById(dispositivoId).orElseThrow();
            dispositivi.delete(d);
            return Optional.of(d);
        }catch (NoSuchElementException ex){
            log.error(String.format("Non sei riuscito a eliminare"),ex);
            throw new RuntimeException("Dispositivo non trovato");
        }catch(Exception ex){
            log.error(String.format("Non sei riuscito a eliminare"));
            throw new RuntimeException();

        }

    }

    @Override
    public Dispositivo assegna(Long dispositivoId, Long dipendenteId) {
        var d = dispositivi.findById(dispositivoId).orElseThrow(() ->new RuntimeException("Dispositivo non trovato"));
        if(d.getDeviceStatus() != DeviceStatus.DISPONIBILI){
            throw new RuntimeException("Dispositivo non disponibile");
        }
        var a = dipendenti.findById(dipendenteId)
                .orElseThrow(() ->new RuntimeException("Dipentente non esiste"));
        d.setDipendente(a);
        d.setDeviceStatus(DeviceStatus.ASSEGNATO);
        return dispositivi.save(d);

    }

    @Override
    public Dispositivo rimuovi(Long dispositivoId, Long dipendenteId) {
        var d =dispositivi.findById(dispositivoId)
                .orElseThrow(() ->new RuntimeException("Dispositivo non disponibile"));
        if(d.getDipendente() == null || !d.getDipendente().getId().equals(dipendenteId)){
            throw new RuntimeException("Dispositivo non puo' essere assegnato il dipendente");
        }
        d.setDipendente(null);
        d.setDeviceStatus(DeviceStatus.DISPONIBILI);
        return dispositivi.save(d);
    }
}
