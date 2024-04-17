package Sim;

import java.util.Arrays;

public class Sim {
    private String number;
    private int credito;
    private Calls[] calls;



    public Sim(String n){
        number = n;
        credito = 0;
        this.calls = new Calls[0];
    }

    public Calls[] getCalls() {
        return calls;
    }

    public void setCalls(Calls[] calls) {
        this.calls = calls;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void stampaSim(){
        System.out.println("Questo e' il numero " + this.getNumber());
        System.out.println("Questo e' il credito " + this.getCredito());
        System.out.println( "Le ultime 5 chiamate: " + Arrays.toString(this.getCalls()));
    }

}
