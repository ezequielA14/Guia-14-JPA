package libreria.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import libreria.entidades.*;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Ezequiel
 */
public class LibroService {

    public static void crearLibro() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {

            System.out.print("Ingrese el ID del autor del libro: ");
            Integer idAutor = leer.nextInt();
            Autor autor = AutorDAO.buscarAutorPorId(idAutor);

            if (autor == null) {
                throw new Exception("Debe indicar un ID de autor válido.");
            }

            System.out.print("Ingrese el ID de la editorial del libro: ");
            Integer idEditorial = leer.nextInt();
            Editorial editorial = EditorialDAO.buscarEditorialPorId(idEditorial);

            if (editorial == null) {
                throw new Exception("Debe indicar un ID de editorial válido.");
            }

            System.out.print("Ingrese el número de ISBN");
            Long isbn = leer.nextLong();

            if (isbn == null || isbn.toString().length() <= 12) {
                throw new Exception("Debe indicar un número de ISBN válido");
            }

            System.out.print("Ingrese el titulo del libro: ");
            String titulo = leer.next();

            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar un titulo válido");
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

            if (ejemplaresPrestados == null || ejemplaresPrestados < 0) {
                throw new Exception("Debe indicar una cantidad de ejemplares prestados válida");
            }

            System.out.print("Ingrese la cantidad de ejemplares restantes del libro: ");
            Integer ejemplaresRestantes = leer.nextInt();

            if (ejemplaresRestantes == null || ejemplaresRestantes < 0) {
                throw new Exception("Debe indicar una cantidad de ejemplares restantes válida");
            }

            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            LibroDAO.guardarLibro(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void modificarTituloLibro() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el número de ISBN del libro que desea editar: ");
            Long isbn = leer.nextLong();

            if (isbn == null || isbn <= 0) {
                throw new Exception("Debe de indicar un número de ISBN válido");
            }

            System.out.print("Ingrese el nuevo titulo del libro: ");
            String titulo = leer.next();

            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe ingresar un titulo válido");
            }

            Libro libro = LibroDAO.buscarLibroPorISBN(isbn);
            libro.setTitulo(titulo);

            LibroDAO.modificarLibro(libro);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarAutor() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el ID del autor que desea eliminar: ");
            Integer id = leer.nextInt();

            if (id == null || id <= 0) {
                throw new Exception("Debe indicar una ID válida");
            }

            Autor autor = AutorDAO.buscarAutorPorId(id);
            AutorDAO.eliminarAutor(autor);
            autor.setAlta(Boolean.FALSE);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirLibros() throws Exception {
        try {
            for (Libro libro : listarLibros()) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirLibroPorISBN() throws Exception {
        try {
            System.out.println(LibroDAO.buscarLibroPorISBN(Long.MIN_VALUE));

        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirLibroPorTitulo() throws Exception {
        try {

            System.out.println("");

        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Libro> listarLibros() throws Exception {
        try {

            ArrayList<Libro> libros = LibroDAO.listarLibros();

            if (libros.isEmpty()) {
                throw new Exception("No hay libros para imprimir.");
            }

            return libros;
        } catch (Exception e) {
            throw e;
        }
    }
}
