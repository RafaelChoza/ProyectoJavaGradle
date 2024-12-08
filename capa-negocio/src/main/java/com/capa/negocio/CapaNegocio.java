package com.capa.negocio;

import com.capa.datos.*;
import com.capa.datos.MiExcepcion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CapaNegocio {
    private Libreria libreria;

    public CapaNegocio(Libreria libreria) {
        this.libreria = libreria;
    }

    public void agregarLibro(Libro libro) {
        libreria.agregarLibro(libro);
    }
    public void agregarAutor(Autor autor) {
        libreria.agregarAutor(autor);
    }
    public void agregarUsuario(Usuario usuario) {
        libreria.agregarUsuario(usuario);
    }

    public void eliminarLibroPorTitulo(String titulo) {
        libreria.eliminarLibroPorTitulo(titulo);
    }

    public void eliminarAutorPorNombre(String nombre) {
        libreria.eliminarAutorPorNombre(nombre);
    }

    public void eliminarUsuarioPorNombre(String nombre) {
        libreria.eliminarUsusarioPorNombre(nombre);
    }

    public void mostrarLibreria() {
        System.out.println(libreria);
    }

    public void mostrarLibrosPorTitulo(String titulo) {
        try {
            List<Libro> libros = libreria.obtenerLibrosPorTitulo(titulo);
            if (libros.isEmpty()) {
                System.out.println("No se encontraron libros con el título: " + titulo);
            } else {
                System.out.println("Libros encontrados con el título '" + titulo + "':");
                for (Libro libro : libros) {
                    System.out.println(libro);
                }
            }
        } catch (MiExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void mostrarLibrosPorAutor(String autor) {
        try {
            List<Libro> librosDelAutor = libreria.obtenerLibrosPorAutor(autor);
            if(librosDelAutor.isEmpty()) {
                System.out.println("No se encontraron libros del autor " + autor);
            } else {
                System.out.println("Libros encontrados del autor "+ autor + " :");
                for (Libro libro : librosDelAutor) {
                    System.out.println(libro);
                }
            }
        } catch (MiExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    public void mostrarUsusariosPorNombre(String nombre) {
        try {
            List<Usuario> usuariosEncontrado = libreria.obtenerUsuariosPorNombre(nombre);
            if(usuariosEncontrado.isEmpty()) {
                System.out.println("No se encontrarno usuarios con el nombre " + nombre);
            } else {
                System.out.println("Los usuarios encontrados con el nombre " + nombre + " son:");
                for (Usuario usuario : usuariosEncontrado) {
                    System.out.println(usuario);
                }
            }
        } catch (MiExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    public void editarLibro(String tituloLibro, String nuevoTitulo, String nuevoAutor, int nuevoAnio, String nuevoIsbn) {
        Optional<Libro> libroEditado = libreria.editarLibroPorTitulo(tituloLibro, nuevoTitulo, nuevoAutor, nuevoAnio, nuevoIsbn);
        if (libroEditado.isPresent()) {
            System.out.println("Libro editado: " + libroEditado.get());
        } else {
            System.out.println("No se encontró el libro con el título: " + tituloLibro);
        }
    }

    public void editarUsuario(String nombreUsuario, String nuevoNombre, String nuevoCorreo, String nuevaContrasenia) {
        Optional<Usuario> usuarioEditado = libreria.editarUsuarioPorNombre(nombreUsuario, nuevoNombre, nuevoCorreo, nuevaContrasenia);
        if(usuarioEditado.isPresent()) {
            System.out.println("Usuario editado: " + usuarioEditado.get());
        } else {
            System.out.println("No se encontro el usuario de nombre " + nombreUsuario);
        }
    }

    public void editarAutor(String nombreAutor, String nuevoNombreAutor, String nuevoApellidoAutor, String nuevaBiografia) {
        Optional<Autor> autorEditado = libreria.editarAutorPorNombre(nombreAutor, nuevoNombreAutor, nuevoApellidoAutor, nuevaBiografia);
        if(autorEditado.isPresent()) {
            System.out.println("El autor editado: " + autorEditado.get());
        } else {
            System.out.println("No se eoncontro el autor de nombre " + nombreAutor);
        }
    }

}
