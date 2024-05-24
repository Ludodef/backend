package it.epicode.esercizio_venerdi.controller;

import it.epicode.esercizio_venerdi.entities.Dipendente;
import it.epicode.esercizio_venerdi.services.DipendenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteServices dipendenteService;

    @GetMapping
    public ResponseEntity<List<Dipendente>> getAllDipendenti() {
        List<Dipendente> dipendenti = dipendenteService.getDipendenti();
        return ResponseEntity.ok(dipendenti);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        Optional<Dipendente> dipendente = dipendenteService.getDipendente(id);
        return dipendente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dipendente> createDipendente(@RequestBody Dipendente dipendente) {
        Dipendente savedDipendente = dipendenteService.save(dipendente);
        if (savedDipendente != null) {
            return ResponseEntity.ok(savedDipendente);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente) {
        Optional<Dipendente> updatedDipendente = dipendenteService.update(id, dipendente);
        return updatedDipendente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        Optional<Dipendente> deletedDipendente = dipendenteService.delete(id);
        if (deletedDipendente.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
