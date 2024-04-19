package it.player.multimedia;

public abstract class Playable extends Multimedia implements Riproduzione {
    private int duration;
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



    @Override
    public void alzaVolume() {

    }

    @Override
    public void diminuisciVolume() {

    }

    @Override
    public void play() {
    }



}
