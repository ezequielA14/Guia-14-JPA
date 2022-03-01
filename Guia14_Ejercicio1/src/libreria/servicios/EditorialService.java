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
    
    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");

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
            /// Le pedimos al usuario el nombre de la editorial a modificar
            System.out.print("Ingrese el nombre de la editorial que desea editar: ");
            String nombre = leer.next();

            /// Validamos que no ingrese un nombre vacio o null
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe de indicar un nombre válido");
            }

            /// Buscamos la editorial según el nombre
            Editorial editorial = EditorialDAO.buscarEditorialPorNombre(nombre);

            /// Validamos que la editorial exista
            if (editorial == null) {
                throw new Exception("La editorial que busca no existe");
            }

            /// Le pedimos al usuario el nuevo nombre de la editorial
            System.out.print("Ingrese el nuevo nombre de la editorial: ");
            String nombreNuevo = leer.next();

            /// Validamos que el nuevo nombre no sea un dato vacio o null
            if (nombreNuevo == null || nombreNuevo.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre válido");
            }

            editorial.setNombre(nombreNuevo);

            /// Modificamos la editorial
            EditorialDAO.modificarEditorial(editorial);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void eliminarEditorial() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            /// Le pide al usuario el nombre de la editorial a eliminar
            System.out.print("Ingrese el nombre de la editorial que desea eliminar: ");
            String nombre = leer.next();

            /// Valida que el nombre no esté vacio o null
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre válido");
            }

            /// Busca la editorial según el nombre
            Editorial editorial = EditorialDAO.buscarEditorialPorNombre(nombre);

            if (editorial == null) { /// Valida que la editorial exista
                throw new Exception("La editorial no existe...");
            }

            if (editorial.getAlta()) { /// Si la editorial existe, entonces válida que la editorial no esté eliminada
                editorial.setAlta(Boolean.FALSE); /// Si la editorial no está eliminada, le setea el alta como false.
                System.out.println("La editorial ha sido eliminada exitosamente!");
            } else {
                /// Si la editorial tiene el alta igual a false, entonces informa que ya fue eliminada
                throw new Exception("La editorial ya ha sido eliminada!");
            }

//            EditorialDAO.eliminarEditorial(editorial); Es mala practica eliminar tuplas.
            EditorialDAO.modificarEditorial(editorial);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
    
    public static void imprimirEditorialPorNombre() {
        try {
            System.out.print("Ingrese el nombre de la editorial: ");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre válido");
            }

            Editorial editorial = EditorialDAO.buscarEditorialPorNombre(nombre);

            if (editorial == null) {
                throw new Exception("No existe ningúna editorial con ese nombre");
            }

            System.out.println(editorial);

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
