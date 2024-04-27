package it.epicode.libreria;

public class Riviste extends Composizione{
    private Uscita uscita;

    public Riviste(Long ISBN,String titolo, int anno,int pagine,Uscita uscita) {
        this.uscita = uscita;

        super.setISBN(ISBN);
        super.setTitolo(titolo);
        super.setAnno(anno);
        super.setPagine(pagine);
    }

    public Uscita getUscita() {
        return uscita;
    }

    public void setUscita(Uscita uscita) {
        this.uscita = uscita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "uscita=" + uscita +
                '}';
    }
}
