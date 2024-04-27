package it.epicode.libreria;

public class Libri extends Composizione{

    private String autore;
    private String genere;

    public Libri(Long ISBN,String titolo, int anno,int pagine,String autore, String genere) {
        this.autore = autore;
        this.genere = genere;
        super.setISBN(ISBN);
        super.setTitolo(titolo);
        super.setAnno(anno);
        super.setPagine(pagine);
    }

    //getter e setter
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
