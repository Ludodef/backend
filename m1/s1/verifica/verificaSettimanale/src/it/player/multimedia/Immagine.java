package it.player.multimedia;

public class Immagine extends Multimedia implements Visualizzazione{
    //classe immagine che estende Multimedia e implementa Visualizzazione(interfaccia)

    private int luminosita = 5;

    public Immagine(String titolo){
        this.setTitle(titolo);

    }


    public int getLuminosita() {
        return luminosita;
    }




    //metodo show che ci permette di visualizzare l'immagine
    public void show(){
        System.out.print(this.getTitle() + "-");
        for (int i = 0; i < this.getLuminosita();i++){
            System.out.print("*");

        }

    }

    //metodi per la luminosita' esportati dall'interfaccia Visualizzazione e definiti
    @Override
    public void aumentaLuminosita() {
        if(luminosita < 10){
            luminosita++;
        }else {
            System.out.println("Luminosità massima");
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        } else {
            System.out.println("Luminosità minima");
        }
    }

    }
