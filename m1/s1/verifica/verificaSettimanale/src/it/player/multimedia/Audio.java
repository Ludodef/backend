package it.player.multimedia;

public class Audio extends Playable{

    //implementazione della classe Playable per esportare i suoi metodi


    //Costruttore di audio
    public Audio(String titolo, int durata){

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
            System.out.println(" ");
        }
    }
}
