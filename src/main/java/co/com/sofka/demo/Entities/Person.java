package co.com.sofka.demo.Entities;

public class Person {
    private String nombre;

    public Person(){

    }
    public Person(String nombre){
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
