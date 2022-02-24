package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.*;
import libreria.persistencia.*;

/**
 *
 * @author Ezequiel
 */
public class LibroService {

    public static void crearLibro() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {

            System.out.print("Ingrese el nombre del autor del libro: ");
            String nombreA = leer.next();
            Autor autor = AutorDAO.buscarAutorPorNombre(nombreA);

            if (autor == null) {
                throw new Exception("Debe indicar un nombre de autor válido.");
            }

            System.out.print("Ingrese el nombre de la editorial del libro: ");
            String nombreE = leer.next();
            Editorial editorial = EditorialDAO.buscarEditorialPorNombre(nombreE);

            if (editorial == null) {
                throw new Exception("Debe indicar un nombre de editorial válido.");
            }

            System.out.print("Ingrese el titulo del libro: ");
            String titulo = leer.next();

            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar un titulo válido");
            } else if (LibroDAO.buscarLibroPorTitulo(titulo) != null) {
                throw new Exception("Ya existe un libro con ese titulo en la base de datos");
            }

            System.out.print("Ingrese el año de lanzamiento del libro: ");
            Integer anio = leer.nextInt();

            if (anio == null) {
                throw new Exception("Debe indicar un año válido");
            }

            System.out.print("Ingrese la cantidad de ejemplares del libro: ");
            Integer ejemplares = leer.nextInt();

            if (ejemplares == null || ejemplares < 0) {
                throw new Exception("Debe indicar una cantidad de ejemplares válida");
            }

            System.out.print("Ingrese la cantidad de ejemplares prestados del libro: ");
            Integer ejemplaresPrestados = leer.nextInt();

            if (ejemplaresPrestados == null || ejemplaresPrestados < 0 || ejemplaresPrestados > ejemplares) {
                throw new Exception("Debe indicar una cantidad de ejemplares prestados válida");
            }

            Integer ejemplaresRestantes = ejemplares - ejemplaresPrestados;

            if (ejemplaresRestantes == null || ejemplaresRestantes < 0) {
                throw new Exception("Los ejemplares restantes no pueden ser menor a cero (0) o nulos");
            }

            Libro libro = new Libro();
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setAlta(Boolean.TRUE);
            LibroDAO.guardarLibro(libro);
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void modificarTituloLibro() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el titulo del libro que desea editar: ");
            String titulo = leer.next();

            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe de indicar un titulo válido");
            }

            System.out.print("Ingrese el nuevo titulo del libro: ");
            String tituloNuevo = leer.next();

            if (tituloNuevo == null || tituloNuevo.trim().isEmpty() || tituloNuevo.equals(titulo)) {
                throw new Exception("Debe ingresar un titulo válido");
            }

            Libro libro = LibroDAO.buscarLibroPorTitulo(titulo);
            libro.setTitulo(tituloNuevo);

            LibroDAO.modificarLibro(libro);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarLibro() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el titulo del libro que desea eliminar: ");
            String titulo = leer.next();

            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar un titulo válido");
            }

            Libro libro = LibroDAO.buscarLibroPorTitulo(titulo);
            if (libro.getAlta()) {
                libro.setAlta(Boolean.FALSE);
                System.out.println("El libro ha sido eliminado");
            } else {
                System.out.println("El libro ya está eliminado");
            }

//            LibroDAO.eliminarLibro(libro); En este caso el ejercicio pide que no lo eliminemos, que le pongamos que el alta es FALSE.
            LibroDAO.modificarLibro(libro);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirLibros() throws Exception {
        try {
            List<Libro> libros = LibroDAO.listarLibros();

            if (libros.isEmpty()) {
                throw new Exception("No hay libros para imprimir.");
            }

            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirLibrosEliminados() throws Exception {
        try {
            List<Libro> libros = LibroDAO.listarLibrosEliminados();

            if (libros.isEmpty()) {
                throw new Exception("No hay libros para imprimir.");
            }

            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirLibroPorISBN() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el número de ISBN del libro: ");
            Long isbn = leer.nextLong();

            if (isbn == null || isbn <= 0) {
                throw new Exception("Debe indicar un número de ISBN válido");
            }

            Libro libro = LibroDAO.buscarLibroPorISBN(isbn);

            if (libro == null) {
                throw new Exception("No existe ningún libro con ese número de ISBN");
            }

            System.out.println(libro);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirLibroPorTitulo() throws Exception {
        try {
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.print("Ingrese el titulo del libro: ");
            String titulo = leer.next();

            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar un titulo válido");
            }

            Libro libro = LibroDAO.buscarLibroPorTitulo(titulo);

            if (libro == null) {
                throw new Exception("No existe ningún libro con ese titulo");
            }

            System.out.println(libro);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirLibrosPorAutor() throws Exception {
        try {
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.print("Ingrese el nombre del autor del/los libro/s: ");
            String autor = leer.next();

            if (autor == null || autor.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre de autor válido");
            }

            List<Libro> libros = LibroDAO.buscarLibrosPorAutor(autor);

            if (libros == null) {
                throw new Exception("No existe ningún libro con ese autor");
            }

            for (Libro libro : libros) {
                System.out.println(libro);
            }

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirLibrosPorEditorial() throws Exception {
        try {
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.print("Ingrese el nombre de la editorial del/los libro/s: ");
            String editorial = leer.next();

            if (editorial == null || editorial.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre de editorial válido");
            }

            List<Libro> libros = LibroDAO.buscarLibrosPorEditorial(editorial);

            if (libros == null) {
                throw new Exception("No existe ningún libro con esa editorial");
            }

            for (Libro libro : libros) {
                System.out.println(libro);
            }

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}
