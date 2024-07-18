import java.util.Scanner;

public class Condicionales {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Pon un numero");
        Integer x = Input.nextInt();
        if (x > 0) {
            System.out.println(x +" es positivo");
        }
        
        else if (x < 0) {
            System.out.println(x +" es negativo");
        } 
        
        else {
            System.out.println(x +" es cero");
        }
}
}