package it.player.multimedia;

public abstract class Playable extends Multimedia implements Riproduzione {
    private int duration;
    private int volume = 5;

    public int getVolume() {
        return volume;
    }



    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



    @Override
    public void alzaVolume() {
        if(volume < 10){
            volume++;
        }else {
            System.out.println("Volume massimo");
        }
    }

    @Override
    public void diminuisciVolume() {
        if(volume > 0){
            volume--;
        }else {
            System.out.println("Volume minimo");
        }
    }

    @Override
    public void play() {
    }



}
