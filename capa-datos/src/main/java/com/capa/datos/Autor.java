package com.capa.datos;

import java.util.List;

public class Autor {
    private String nombre;
    private String apellido;
    private String biografia;
    private List<Libro> libros;

    public Autor(String nombre, String apellido, String biografia, List<Libro> libros) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.biografia = biografia;
        this.libros = libros;
    }

    public Autor(String nombre, String apellido, String biografia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.biografia = biografia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", biografia='" + biografia + '\'' +
                ", libros=" + libros +
                '}';
    }
}
