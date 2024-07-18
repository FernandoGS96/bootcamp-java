public class Estudiante extends Persona{
    
    private String grado;


    @Override public void mostrarDetalles(){

        super.mostrarDetalles();
        System.out.println("Grado: " + grado);

    }


    public Estudiante(String nombre, int edad, String grado){
        super(nombre, edad);
        this.grado = grado;


}
    public static void main(String[] args) {

        Persona p1 = new Estudiante("Juan", 34, "suidbh");

        p1.setNombre("Ana");
        p1.setEdad(20);
        p1.mostrarDetalles();

        
    }

}
