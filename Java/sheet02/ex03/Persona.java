

public class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){

        this.nombre = nombre;
        this.edad = edad;
    }
   

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String newNombre){
        nombre = newNombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int newEdad){
        edad = newEdad;
    }

    public  void mostrarDetalles(){

        
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Nameholder", 1000);

        persona.setNombre("Ana");
        persona.setEdad(20);
        persona.mostrarDetalles();

    }
    
}
