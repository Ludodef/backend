package esercizio;

public class Main2 {

    public static String stampaNumero(int num){
        String risultato;
        switch (num){

            case 0:{
                risultato = "zero";
                break;
            }
            case 1:{
                risultato = "uno";
                break;
            }
            case 2:{
                risultato = "due";
                break;
            }
            case 3:{
                risultato = "tre";
                break;
            }
            default:
                risultato = "ERRORE";
        }
    }
}
