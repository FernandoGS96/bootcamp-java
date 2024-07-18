package sheet02.ex03;

public class Estudiante extends Persona{
    
    private String grado;


    @Override public void mostrarDetalles(){

        System.out.println("Grado: " + grado);

    }


    public Estudiante(String nombre, int edad, String grado){
        super(nombre, edad);
        this.grado = grado;


}
    public static void main(String[] args) {

        Persona p1 = new Persona(grado, edad);

        p1.setNombre("Ana");
        p1.setEdad(20);
        p1.mostrarDetalles();

        
    }

}
