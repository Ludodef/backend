package it.epicode.libreria.services;

import ch.qos.logback.core.util.FileUtil;
import it.epicode.libreria.Composizione;
import it.epicode.libreria.Libri;
import it.epicode.libreria.Riviste;
import it.epicode.libreria.Uscita;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUscitaServices implements UsciteService {
    private static final Logger logger = LoggerFactory.getLogger(FileUscitaServices.class);
    private final ArrayList<Composizione> uscite = new ArrayList<>();
    private static final String STORAGE = "./lettura.csv";

    public FileUscitaServices() {
        load();
    }

    public void rimuovidaISBN(Long ISBN){
        uscite.removeIf(u ->u.getISBN().equals(ISBN));
    }
    public List<Composizione> cercaConISBN(Long ISBN){
       return uscite.stream()
                .filter(a -> a.getISBN().equals(ISBN))
                .collect(Collectors.toList());
    }
    public List<Composizione> cercaConAnno(int anno){
        return uscite.stream()
                .filter(a -> a.getAnno() == anno)
                .collect(Collectors.toList());
    }

    public List<Composizione> cercaConAutore(String autore){
        return uscite.stream()
                .filter(a -> a instanceof Libri && ((Libri)a).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public void save() {
        File f = new File(STORAGE);
        try {
            FileUtils.write(f, "", StandardCharsets.ISO_8859_1);
            for (Composizione u : uscite) {
                List<String> lines = new ArrayList<>();
                lines.add(u.getClass().getSimpleName());
                lines.add(u.getISBN().toString());
                lines.add(u.getTitolo());
                lines.add(String.valueOf(u.getAnno()));
                lines.add(String.valueOf(u.getPagine()));
                if (u instanceof Libri) {
                    Libri l = (Libri) u;
                    lines.add(l.getAutore());
                    lines.add(l.getGenere());
                } else if (u instanceof Riviste) {
                    Riviste r = (Riviste) u;
                    lines.add(r.getUscita().toString());

                }
                FileUtils.writeStringToFile(f, String.join(",", lines) + System.lineSeparator(), StandardCharsets.ISO_8859_1, true);
            }
        } catch (IOException e) {

            logger.error("Eccezione durante l'eliminazione del file di storage", e);
        }
    }

    private void load() {
        File f = new File(STORAGE);
        if (!f.exists()) return;
        try {
            List<String> lines = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);
            for (String line : lines) {
                String[] parts = line.split(",");
                Long ISBN = Long.parseLong(parts[1]);
                String titolo = parts[2];
                int anno = Integer.parseInt(parts[3]);
                int pagine = Integer.parseInt(parts[4]);
                if ("Libro".equals(parts[0])) {
                    String autore = parts[5];
                    String genere = parts[6];
                    uscite.add(new Libri(ISBN, titolo, anno, pagine, autore, genere));
                } else if ("Rivista".equals(parts[0])) {
                    Uscita uscita = Uscita.valueOf(parts[5]);
                    uscite.add(new Riviste(ISBN, titolo, anno, pagine, uscita));
                }
            }
        } catch (IOException e) {
            logger.error("Eccezione durante il caricamento", e);
        }


    }

    @Override
    public void addUscita(Composizione u) {
        uscite.add(u);

    }

    @Override
    public void removeUscita(Composizione u) {

    }

    @Override
    public List<Composizione> getUsc() {
        return List.of();
    }
}
