package com.example.usuario.altaslista;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Usuario on 22/03/2018.
 */

class ArrayPersonas {
    private static final ArrayPersonas ourInstance = new ArrayPersonas();

    private List<Persona> personas = new ArrayList<>();

    public int size() {
        return personas.size();
    }

    public boolean isEmpty() {
        return personas.isEmpty();
    }

    public boolean contains(Object o) {
        return personas.contains(o);
    }

    public boolean add(Persona persona) {
        return personas.add(persona);
    }

    public boolean remove(Object o) {
        return personas.remove(o);
    }

    public Persona get(int i) {
        return personas.get(i);
    }

    public Persona set(int i, Persona persona) {
        return personas.set(i, persona);
    }

    public void add(int i, Persona persona) {
        personas.add(i, persona);
    }

    public Persona remove(int i) {
        return personas.remove(i);
    }



    static ArrayPersonas getInstance() {
        return ourInstance;
    }

    private ArrayPersonas() {
    }

    public Persona getPersona(int index) {
        return personas.get(index);
    }

    public void setPersona(int index, Persona persona) {
        personas.set(index,persona);
    }

    public List<Persona> getPersonas() {
        return personas;
    }
}
