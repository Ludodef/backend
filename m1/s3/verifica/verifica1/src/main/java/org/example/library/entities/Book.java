package org.example.library.entities;

import java.util.Date;

public class Book extends Element {

    String author;
    String genere;

    public Book(String title, String ISBN, Date pubblication, int pages, String author, String genere) {
        super(title, ISBN, pubblication, pages);
        this.author = author;
        this.genere = genere;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenere() {
        return genere;
    }
}
