    package com.capa.datos;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;
    import java.util.stream.Collectors;

    public class Libreria {
        List<Autor> autores = new ArrayList<>();
        List<Libro> libros =  new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        public void agregarLibro(Libro libro) {
            libros.add(libro);
        }
        public void agregarAutor(Autor autor) {
            autores.add(autor);
        }
        public void agregarUsuario(Usuario usuario) {
            usuarios.add(usuario);
        }

        public void eliminarLibroPorTitulo(String titulo) {
            libros.removeIf(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()));
        }
        public void eliminarUsusarioPorNombre(String nombre) {
            usuarios.removeIf(usuario -> usuario.getNombre().toLowerCase().contains(nombre.toLowerCase()));
        }
        public void eliminarAutorPorNombre(String nombre) {
            autores.removeIf(autor -> autor.getNombre().toLowerCase().contains(nombre.toLowerCase()));
        }

        public List<Libro> obtenerLibrosPorTitulo(String titulo) throws MiExcepcion {
            List<Libro> librosEncontrados = libros.stream()
                    .filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                    .collect(Collectors.toList());

            if (librosEncontrados.isEmpty()) {
                throw new MiExcepcion("No se encontraron libros con el título: " + titulo);
            }

            return librosEncontrados;
        }


        public List<Libro> obtenerLibrosPorAutor(String autor) throws MiExcepcion {
            List<Libro> librosDelAutor = new ArrayList<>();
            for(Libro libro : libros) {
                if(libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                    librosDelAutor.add(libro);
                } else {
                    throw  new MiExcepcion("No se encontraron libros del autor " + autor);
                }
            }
            return librosDelAutor;
        }

        public List<Usuario> obtenerUsuariosPorNombre(String nombre) throws MiExcepcion {
            List<Usuario> usuariosEncontrados = new ArrayList<>();
            for(Usuario usuario : usuarios) {
                if(usuario.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    usuariosEncontrados.add(usuario);
                } else {
                    throw new MiExcepcion("No se encontraron usuarios con el nombre " + nombre);
                }
            }
            return usuariosEncontrados;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Libros:\n");
            for (Libro libro : libros) {
                sb.append(libro.toString()).append("\n");
            }
            sb.append("Autores:\n");
            for (Autor autor : autores) {
                sb.append(autor.toString()).append("\n");
            }
            sb.append("Usuarios:\n");
            for (Usuario usuario : usuarios) {
                sb.append(usuario.toString()).append("\n");
            }
            return sb.toString();
        }

        public Optional<Libro> editarLibroPorTitulo(String tituloLibro, String nuevoTitulo, String nuevoAutor, int nuevoAnio, String nuevoIsbn) {
            Optional<Libro> libroEncontrado = libros.stream()
                    .filter(libro -> libro.getTitulo().contains(tituloLibro))
                    .findFirst();

            libroEncontrado.ifPresent(libro -> {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setAnio(nuevoAnio);
                libro.setIsbn(nuevoIsbn);
            });

            return libroEncontrado;
        }

        public Optional<Usuario> editarUsuarioPorNombre(String nombreUsuario, String nuevoNombre, String nuevoCorreo, String nuevaContrasenia) {
            Optional<Usuario> usuarioEncontrado = usuarios.stream()
                    .filter(usuario -> usuario.getNombre().contains(nombreUsuario))
                    .findFirst();

            usuarioEncontrado.ifPresent(usuario -> {
                usuario.setNombre(nuevoNombre);
                usuario.setCorreo(nuevoCorreo);
                usuario.setContrasenia(nuevaContrasenia);
            });
            return usuarioEncontrado;
        }

        public Optional<Autor> editarAutorPorNombre(String nombreAutor, String nuevoNombreAutor, String nuevoApellidoAutor, String nuevaBiografia) {
            Optional<Autor> autorEncontrado = autores.stream()
                    .filter(autor -> autor.getNombre().contains(nombreAutor))
                    .findFirst();

            autorEncontrado.ifPresent(autor -> {
                autor.setNombre(nuevoNombreAutor);
                autor.setApellido(nuevoApellidoAutor);
                autor.setBiografia(nuevaBiografia);
            });
            return autorEncontrado;
        }
    }

