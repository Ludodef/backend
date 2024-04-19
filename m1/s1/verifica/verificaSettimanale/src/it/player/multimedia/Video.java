package it.player.multimedia;

public class Video extends Playable implements Visualizzazione {
    private int luminosita = 5;

    public int getLuminosita() {
        return luminosita;
    }



    public Video(String titolo, int durata){

        this.setTitle(titolo);
        this.setDuration(durata);

    }

    @Override
    public void play(){
        for (int i = 0; i < this.getDuration(); i++) {
            System.out.print(this.getTitle() + "-");
            for (int j = 0; j < getVolume(); j++) {
                System.out.print("!");

            }
            System.out.print("-");
            for (int a = 0; a < this.getLuminosita(); a++) {
                System.out.print("*");

            }
            System.out.println(" ");
        }
    }


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
        if(luminosita > 0){
            luminosita--;
        }else {
            System.out.println("Luminosità minima");
        }

    }


    ;
}
