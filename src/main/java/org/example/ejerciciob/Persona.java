package org.example.ejerciciob;

import java.util.Objects;
/**
 * Clase que representa una persona con nombre, apellidos y edad.
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    /**
     * Constructor que inicializa una nueva instancia de Persona.
     * @param n Nombre de la persona.
     * @param a Apellidos de la persona.
     * @param e Edad de la persona.
     */
    public Persona(String n,String a,int e){
        this.nombre=n;
        this.apellidos=a;
        this.edad=e;
    }
    /**
     * Obtiene la edad de la persona.
     * @return Edad de la persona.
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Obtiene el nombre de la persona.
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     * @return  Apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Sobrescribe el método equals para comparar dos personas basándose en sus atributos.
     * @param o Objeto a comparar con esta instancia de Persona.
     * @return true si las personas son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }
    /**
     * Sobrescribe el método hashCode basado en los atributos de la persona.
     * @return Código hash de la persona.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad);
    }
}
