import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
           int a = 3;
           int b = 4;
           int result= multiply(a,b);
           System.out.println(result);

           System.out.println(concat("ciao ", 4));

        String[] arr = insertIntoArray(new String[]{"l", "u", "d", "o", "v"}, "icaa");

        System.out.println(Arrays.toString(arr));

    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static String concat( String str, int num){
        return str + num;
    }

    public static String[] insertIntoArray(String[] stringArray, String str) {
        String[] array = new String[6];
        for (int i = 0; i < stringArray.length +1 ; i++) {
            if(i < 2) {
                array[i] = stringArray[i];
            } else if(i == 2) {
                array[i] = str;
            } else {
                array[i] = stringArray[i - 1];
            }
        }

        return array;
    }


}
