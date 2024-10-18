package org.example.ejerciciob;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    public Persona(String n,String a,int e){
        this.nombre=n;
        this.apellidos=a;
        this.edad=e;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad);
    }
}
