package it.epicode;

import it.epicode.libreria.Composizione;
import it.epicode.libreria.Libri;
import it.epicode.libreria.Riviste;
import it.epicode.libreria.Uscita;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        var libreria = new ArrayList<Composizione>();
        libreria.add(new Libri(123456789L, "Guida galattica per autostoppisti", 1979, 189,"Douglas Adams","fantascenza"));
        libreria.add(new Riviste(987654321L,"Come prendersi cura del giardino",2023,100, Uscita.SEMESTRALE));
        libreria.add(new Libri(456789321L, "Uno stupido libro", 1979, 200,"Pinco Pallino","satira"));


        Long ISBNToSearch = 987654321L;
        int yearToSearch = 1979;
        String authorToSearch = "Pinco Pallino";


        var cercaISBN = libreria.stream()
                .filter(a -> a.getISBN().equals(ISBNToSearch))
                .toList();

        var cercaAnno = libreria.stream()
                .filter(a -> a.getAnno() == yearToSearch)
                .toList();

        var cercaAutore = libreria.stream()
                .filter(a -> a instanceof Libri && ((Libri)a).getAutore().equals(authorToSearch))
                .toList();

            //eliminazione del libro/rivista tramite isbn
            libreria.removeIf(a ->a.getISBN().equals(ISBNToSearch));





        cercaISBN.forEach(a -> System.out.println("L'articolo selezionato e' " + a.getTitolo() + " con ISBN " + ISBNToSearch));

        cercaAnno.forEach(a -> System.out.println("L'articolo selezionato e' " + a.getTitolo() + " pubblicato il " + yearToSearch));
        cercaAutore.forEach(a -> System.out.println("L'articolo selezionato e' " + a.getTitolo()));
    }
}