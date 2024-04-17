package Sim;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Sim sim1 = new Sim("3451695849");
        System.out.println(Arrays.toString(sim1.getCalls()));
        sim1.stampaSim();
    }
}
