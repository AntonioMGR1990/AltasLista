package com.example.usuario.altaslista;

/**
 * Created by Usuario on 22/03/2018.
 */

public class Persona {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    public Persona() {
    }

    public Persona(String nombre, String primerApellido, String segundoApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (nombre != null ? !nombre.equals(persona.nombre) : persona.nombre != null) return false;
        if (primerApellido != null ? !primerApellido.equals(persona.primerApellido) : persona.primerApellido != null)
            return false;
        return segundoApellido != null ? segundoApellido.equals(persona.segundoApellido) : persona.segundoApellido == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (primerApellido != null ? primerApellido.hashCode() : 0);
        result = 31 * result + (segundoApellido != null ? segundoApellido.hashCode() : 0);
        return result;
    }
}
