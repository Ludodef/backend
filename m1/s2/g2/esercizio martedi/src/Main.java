import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci il numero di parole");
        int N = scanner.nextInt();

        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();

        System.out.println("inserisci le parole");
        for (int i = 0; i < N; i++) {
            String parola = scanner.next();
            if (!paroleDistinte.add(parola)){
                paroleDuplicate.add(parola);
            }
        }
        scanner.close();

        System.out.println("Parole Duplicate:");
        for (String parola : paroleDuplicate) {
            System.out.println(parola);
        }
        System.out.println("Parole Distinte numero:" + paroleDistinte.size());

        System.out.println("Elenco di Parole Distinte:");
        for (String parola :paroleDistinte){
            System.out.println(parola);
        }
    }
}