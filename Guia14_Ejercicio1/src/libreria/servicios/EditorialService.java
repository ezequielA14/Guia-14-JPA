package libreria.servicios;

import java.util.List;
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
            } else if (EditorialDAO.buscarEditorialPorNombre(nombre) != null) {
                throw new Exception("Ya existe una editorial con ese nombre en la base de datos");
            }

            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorial.setAlta(Boolean.TRUE);
            EditorialDAO.guardarEditorial(editorial);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
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
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void eliminarEditorial() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el nombre de la editorial que desea eliminar: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar una ID válida");
            }

            Editorial editorial = EditorialDAO.buscarEditorialPorNombre(nombre);
            if (editorial.getAlta()) {
                editorial.setAlta(Boolean.FALSE);
                System.out.println("La editorial ha sido eliminada");
            } else {
                System.out.println("La editorial ya ha sido eliminada");
            }

//            EditorialDAO.eliminarEditorial(editorial); Es mala practica eliminar tuplas.
            EditorialDAO.modificarEditorial(editorial);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirEditoriales() throws Exception {
        try {
            List<Editorial> editoriales = EditorialDAO.listarEditoriales();

            if (editoriales.isEmpty()) {
                throw new Exception("No hay editoriales para imprimir");
            }

            for (Editorial editorial : editoriales) {
                System.out.println(editorial);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirEditorialesEliminadas() throws Exception {
        try {
            List<Editorial> editoriales = EditorialDAO.listarEditorialesEliminadas();

            if (editoriales.isEmpty()) {
                throw new Exception("No hay editoriales para imprimir");
            }

            for (Editorial editorial : editoriales) {
                System.out.println(editorial);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

}
