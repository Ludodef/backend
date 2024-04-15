//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
           int a = 3;
           int b = 4;
           int result= multiply(a,b);
           System.out.println(result);

           System.out.println(concat("ciao ", 4));

    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static String concat( String str, int num){
        return str + num;
    }


}
