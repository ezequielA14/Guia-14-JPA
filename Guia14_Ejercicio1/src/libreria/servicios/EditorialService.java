package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author Ezequiel
 */
public class EditorialService {

    public static void crearEditorial() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {

            System.out.print("Ingrese el nombre de la editorial: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre para la editorial.");
            }

            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);

            EditorialDAO.guardarEditorial(editorial);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void modificarNombreEditorial() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el ID de la editorial que desea editar: ");
            Integer id = leer.nextInt();

            if (id == null || id <= 0) {
                throw new Exception("Debe de indicar un ID válido");
            }

            System.out.print("Ingrese el nuevo nombre de la editorial: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre válido");
            }

            Editorial editorial = EditorialDAO.buscarEditorialPorId(id);
            editorial.setNombre(nombre);

            EditorialDAO.modificarEditorial(editorial);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarEditorial() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el ID de la editorial que desea eliminar: ");
            Integer id = leer.nextInt();

            if (id == null || id <= 0) {
                throw new Exception("Debe indicar una ID válida");
            }

            Editorial editorial = EditorialDAO.buscarEditorialPorId(id);
            EditorialDAO.eliminarEditorial(editorial);
            editorial.setAlta(Boolean.FALSE);

        } catch (Exception e) {
            throw e;
        }
    }

}
