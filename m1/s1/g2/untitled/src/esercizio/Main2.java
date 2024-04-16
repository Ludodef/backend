package esercizio;

public class Main2 {


        public static void main(String[] args){
            System.out.println(stampaNumero(3));
        }
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
        return risultato;
    }
}
