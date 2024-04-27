package it.epicode.libreria.services;

import it.epicode.libreria.Composizione;
import it.epicode.libreria.Uscita;

import java.util.List;

public interface UsciteService {
    void addUscita(Composizione u);
    List<Composizione> getUsc();


}
