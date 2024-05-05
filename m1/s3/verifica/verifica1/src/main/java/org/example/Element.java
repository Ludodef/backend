package org.example;

import java.util.Date;

public abstract class Element {
    String ISBN;
    String title;
    Date pubblication;
    int pages;

    public Element(String title, String ISBN, Date pubblication, int pages) {
        this.title = title;
        this.ISBN = ISBN;
        this.pubblication = pubblication;
        this.pages = pages;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getPubblication() {
        return pubblication;
    }

    public void setPubblication(Date pubblication) {
        this.pubblication = pubblication;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
