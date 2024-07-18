import java.util.Scanner;

public class OperacionesAritmeticas {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Pon un numero");
        Integer x = Input.nextInt();
        System.out.println("Pon otro");
        Integer y = Input.nextInt();
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        if (y==0){
            System.out.println("No podes dividir entre cero");
        } 
        else {
            System.out.println(x / y);
        }
        
   Input.close();

}
}