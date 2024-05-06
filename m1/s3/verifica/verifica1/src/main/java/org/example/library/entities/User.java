package org.example.library.entities;

import java.util.Date;

public class User {

    String nome;
    String cognome;
    Date birthDate;
    int card;

    public User (String nome, String cognome, Date birthDate, int card) {
        this.nome = nome;
        this.cognome = cognome;
        this.birthDate = birthDate;
        this.card = card;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getCard() {
        return card;
    }
}
