import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Pon una palabra");
        String y = Input.nextLine();
        pali(y);
        
    }


    static void pali(String x){

        String rev = "";
        String respuesta = "";

        for (int i = x.length() - 1; i >= 0; i--) {
            
            rev = rev + x.charAt(i);
            
        }


        if (x.equals(rev)) {
            respuesta = "Es un palindromo";

        }
        else {
            respuesta = "No es un palindromo";
    
        }

        System.out.println(respuesta);
        
    }
}
