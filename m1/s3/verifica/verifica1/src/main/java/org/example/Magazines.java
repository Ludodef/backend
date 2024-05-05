package org.example;

import java.util.Date;

public class Magazines extends Element {

    private Periodicity periodicita;

    public Magazines(String title, String ISBN, Date pubblication, int pages, Periodicity periodicita) {
        super(title, ISBN, pubblication, pages);
    }

    public Periodicity getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicity periodicita) {
        this.periodicita = periodicita;
    }
}