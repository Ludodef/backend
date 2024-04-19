package it.player;

import it.player.multimedia.Audio;
import it.player.multimedia.Immagine;
import it.player.multimedia.Video;

public class Main {
    public static void main(String[] args) {

        Video prova = new Video("prova",10);
        prova.diminuisciLuminosita();
        prova.alzaVolume();
        prova.play();

        Audio prova2 = new Audio("prova2",10);
        prova2.alzaVolume();
        prova2.play();

        Immagine prova3 = new Immagine("prova3");

        prova3.aumentaLuminosita();
        prova3.show();

    }
}