package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Ezequiel
 */
public class AutorService {

    public static void crearAutor() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el nombre del autor: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre válido");
            } else if (AutorDAO.buscarAutorPorNombre(nombre) != null) {
                throw new Exception("Ya existe un autor con ese nombre en la base de datos");
            }

            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(Boolean.TRUE);
            AutorDAO.guardarAutor(autor);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void modificarNombreAutor() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el nombre del autor que desea editar: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe de indicar un nombre válido");
            }

            System.out.print("Ingrese el nuevo nombre del autor: ");
            String nuevoNombre = leer.next();

            if (nuevoNombre == null || nuevoNombre.trim().isEmpty() || nuevoNombre.equals(nombre)) {
                throw new Exception("Debe ingresar un nombre nuevo válido");
            }

            Autor autor = AutorDAO.buscarAutorPorNombre(nombre);
            autor.setNombre(nombre);

            AutorDAO.modificarAutor(autor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarAutor() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el nombre del autor que desea eliminar: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre válido");
            }

            Autor autor = AutorDAO.buscarAutorPorNombre(nombre);
            if (autor.getAlta()) {
                autor.setAlta(Boolean.FALSE);
                System.out.println("El autor ha sido eliminado");
            } else {
                System.out.println("El autor ya está eliminado");
            }

//            AutorDAO.eliminarAutor(autor); En este caso el ejercicio pide que no lo eliminemos, que le pongamos que el alta es FALSE.
            AutorDAO.modificarAutor(autor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirAutores() throws Exception {
        try {

            List<Autor> autores = AutorDAO.listarAutores();

            if (autores.isEmpty()) {
                throw new Exception("No hay autores para imprimir");
            }

            for (Autor autor : autores) {
                System.out.println(autor);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirAutoresEliminados() throws Exception {
        try {

            List<Autor> autores = AutorDAO.listarAutoresEliminados();

            if (autores.isEmpty()) {
                throw new Exception("No hay autores para imprimir");
            }

            for (Autor autor : autores) {
                System.out.println(autor);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirAutorPorNombre() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
            System.out.print("Ingrese el nombre del autor: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre válido");
            }

            Autor autor = AutorDAO.buscarAutorPorNombre(nombre);

            if (autor == null) {
                throw new Exception("No existe ningún autor con ese nombre");
            }

            System.out.println(autor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
