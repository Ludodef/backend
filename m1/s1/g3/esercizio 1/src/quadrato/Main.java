package quadrato;

public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo1 = new Rettangolo();
        rettangolo1.setAltezza(3);
        rettangolo1.setLarghezza(7);

        Rettangolo rettangolo2 = new Rettangolo();
        rettangolo2.setLarghezza(38);
        rettangolo2.setAltezza(49);

        System.out.println(rettangolo1.perimetro());
        System.out.println(rettangolo1.area());
        stampaRettangolo(rettangolo1);
        stampaDueRettangoli(rettangolo1 ,rettangolo2);
    }

    public static void stampaRettangolo(Rettangolo rettangolo){
        System.out.println("Questo rettangolo ha l'area di " + rettangolo.area() + " Questo e' il perimetro " + rettangolo.perimetro());
    }
    public static void stampaDueRettangoli(Rettangolo rett1, Rettangolo rett2){
        int sommaArea= rett1.area() + rett2.area();
        int sommaPerimetro = rett1.perimetro() + rett2.perimetro();
        System.out.println("Questo rettangolo ha l'area di " + rett1.area() + " Questo e' il perimetro " + rett1.perimetro());
        System.out.println("Questo rettangolo ha l'area di " + rett2.area() + " Questo e' il perimetro " + rett2.perimetro());
        System.out.println("Questa e' la somma dell'area di due rettangoli " + sommaArea);
        System.out.println("Questa e' la somma del perimetro di due rettangoli " + sommaPerimetro);
    }
}