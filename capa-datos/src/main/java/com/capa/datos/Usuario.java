package com.capa.datos;

import java.util.List;

public class Usuario{
    private String nombre;
    private String correo;
    private String contrasenia;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String correo, String contrasenia, List<Libro> librosPrestados) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.librosPrestados = librosPrestados;
    }

    public Usuario(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", librosPrestados=" + librosPrestados +
                '}';
    }
}
