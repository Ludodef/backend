package it.player;

import it.player.multimedia.Audio;
import it.player.multimedia.Immagine;
import it.player.multimedia.Video;

public class Main {

    //CLASSE GENITORE PER LA PROVA DEI VARI METODI

    public static void main(String[] args) {

        //Prova creazione,impostazione luminosita'  e modifica del volume del video
        Video prova = new Video("prova",10); //creazione video
        prova.diminuisciLuminosita(); //diminuisci luminosita'
        prova.alzaVolume(); //alza volume
        prova.play(); //avvio video

        //Prova creazione,modifica del volume dell'audio
        Audio prova2 = new Audio("prova2",10); //creazione audio
        prova2.alzaVolume(); //aumento volume
        prova2.play(); //avvio audio

        Immagine prova3 = new Immagine("prova3"); //creazione immagine
        prova3.aumentaLuminosita(); //aumento luminosita'
        prova3.show(); //mostra immagine

    }
}