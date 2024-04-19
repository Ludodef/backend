package it.player.multimedia;

public class Immagine extends Multimedia implements Visualizzazione{

    private int luminosita;


    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }



    public void show(){
        System.out.print(this.getTitle() + "-");
        for (int i = 0; i < this.getLuminosita();i++){
            System.out.print("*");

        }

    }


    @Override
    public void aumentaLuminosita() {
        if(luminosita < 100){
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
