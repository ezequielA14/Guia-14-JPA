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
            }

            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(Boolean.TRUE);
            AutorDAO.guardarAutor(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modificarNombreAutor() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el ID del autor que desea editar: ");
            Integer id = leer.nextInt();

            if (id == null || id <= 0) {
                throw new Exception("Debe de indicar un ID válido");
            }

            System.out.print("Ingrese el nuevo nombre del autor: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre válido");
            }

            Autor autor = AutorDAO.buscarAutorPorId(id);
            autor.setNombre(nombre);

            AutorDAO.modificarAutor(autor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
