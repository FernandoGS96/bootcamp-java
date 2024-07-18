public class Funciones {
    public static void main(String[] args) {
        if (args.length == 2)
            suma( Integer.valueOf(args[0]),  Integer.valueOf(args[1]));
        else
            System.err.println("Error, este programa requiere de dos y sólo dos argumentos");
}

static void suma(int x, int y) {
    System.out.println("La suma es de los argumentos es " + (x + y));
  }

}