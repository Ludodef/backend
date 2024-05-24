package it.epicode.esercizio_venerdi.controller;

import it.epicode.esercizio_venerdi.entities.Dispositivo;
import it.epicode.esercizio_venerdi.services.DispositivoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {
    @Autowired
    private DispositivoServices dispositivoService;

    @GetMapping
    public ResponseEntity<List<Dispositivo>> getAllDispositivi() {
        List<Dispositivo> dispositivi = dispositivoService.getDispositivi();
        return ResponseEntity.ok(dispositivi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
        Optional<Dispositivo> dispositivo = dispositivoService.getDispositivo(id);
        return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        Dispositivo savedDispositivo = dispositivoService.save(dispositivo);
        if (savedDispositivo != null) {
            return ResponseEntity.ok(savedDispositivo);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        Optional<Dispositivo> updatedDispositivo = dispositivoService.update(id, dispositivo);
        return updatedDispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        Optional<Dispositivo> deletedDispositivo = dispositivoService.delete(id);
        if (deletedDispositivo.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/assegna/{dispositivoId}/{dipendenteId}")
    public ResponseEntity<Dispositivo> assegnaDispositivo(@PathVariable Long dispositivoId, @PathVariable Long dipendenteId) {
        try {
            Dispositivo assegnatoDispositivo = dispositivoService.assegna(dispositivoId, dipendenteId);
            return ResponseEntity.ok(assegnatoDispositivo);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/rimuovi/{dispositivoId}/{dipendenteId}")
    public ResponseEntity<Dispositivo> rimuoviDispositivoAssegnato(@PathVariable Long dispositivoId, @PathVariable Long dipendenteId) {
        try {
            Dispositivo rimossoDispositivo = dispositivoService.rimuovi(dispositivoId, dipendenteId);
            return ResponseEntity.ok(rimossoDispositivo);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
