package esercizio;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserire un numero seguito dal tasto Invio");
        int test = scan.nextInt();
        countdown(test);
        scan.close();
    }

    public static void countdown(int num){
        for (int i = num;i >=0; i-- ){
            System.out.println(i);
        }
    }
}
