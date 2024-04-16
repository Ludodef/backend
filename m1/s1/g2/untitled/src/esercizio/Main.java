package esercizio;


public class Main {

    public static boolean PariDispari(String word){
            if(word.length() % 2 == 0){
                return true;
            }else{
                return false;
            }

    }

    public static boolean annoBisestile(int anno){
        if(anno % 400 == 0){
            return true;
        } else if (anno % 4 == 0 && anno % 100 != 0) {
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(PariDispari("ciao"));
        System.out.println(annoBisestile(2000));


    }
}