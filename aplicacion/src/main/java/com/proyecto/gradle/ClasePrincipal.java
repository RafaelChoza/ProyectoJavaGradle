package com.proyecto.gradle;

import com.capa.datos.*;
import com.capa.negocio.CapaNegocio;
import com.capa.datos.MiExcepcion;


public class ClasePrincipal {
    public static void main(String[] args) throws MiExcepcion {
        Libreria libreria = new Libreria();
        CapaNegocio capaNegocio = new CapaNegocio(libreria);

        Libro libro1 = new Libro("El perfume", "Patrick Suskind", 1956, "ISBN123");
        Libro libro2 = new Libro("Yo Robot", "Isaac Asimov", 1974, "ISBN456");
        Autor autor1 = new Autor("Isaac", "Asimov", "Escritor ruso");
        Autor autor2 =new Autor("Patrick", "Suskind", "Escritor aleman");
        Usuario usuario1 = new Usuario("Carlos", "carlos@correo.com", "haynanitas");
        Usuario usuario2 = new Usuario("Raymundo", "raymundo@correo.com", "123456");

        capaNegocio.agregarLibro(libro1);
        capaNegocio.agregarLibro(libro2);
        capaNegocio.agregarAutor(autor1);
        capaNegocio.agregarAutor(autor2);
        capaNegocio.agregarUsuario(usuario1);
        capaNegocio.agregarUsuario(usuario2);

        System.out.println("*** Estado inicial de la Libreria ***");
        capaNegocio.mostrarLibreria();

        capaNegocio.eliminarLibroPorTitulo("perfume");
        capaNegocio.eliminarAutorPorNombre("Isaac");
        capaNegocio.eliminarUsuarioPorNombre("Carlos");

        System.out.println("--- Estado de la Libreria despues de eliminaciones ---");
        capaNegocio.mostrarLibreria();

        capaNegocio.mostrarLibrosPorTitulo("Robot");

        capaNegocio.mostrarLibrosPorAutor("Isaac");
        capaNegocio.mostrarLibrosPorAutor("Isaac");
        capaNegocio.mostrarUsusariosPorNombre("Raymundo");


        System.out.println("*** Libro Editado ***");
        capaNegocio.editarLibro("Yo Robot", "El Robot", "Chacho Guzman", 2024, "ISBN489-984");
        capaNegocio.mostrarLibreria();

        System.out.println("--- Usuario Editado ---");
        capaNegocio.editarUsuario("Raymundo", "Ray", "ray@correo.com", "OsoPeludo");
        capaNegocio.mostrarLibreria();

        System.out.println("*** Autor Editado ***");
        capaNegocio.editarAutor("Patrick", "Patricio", "Perez", "Escritor cubano");
        capaNegocio.mostrarLibreria();
    }
}