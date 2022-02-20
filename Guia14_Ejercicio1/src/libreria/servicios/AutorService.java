package libreria.servicios;

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
            AutorDAO.guardarAutor(autor);
        } catch (Exception e) {
            throw e;
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

}
