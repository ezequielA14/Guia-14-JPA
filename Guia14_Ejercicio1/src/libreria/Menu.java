package libreria;

import libreria.servicios.LimpiarAnt;
import java.util.Scanner;
import libreria.servicios.*;

/**
 *
 * @author Ezequiel
 */
public class Menu {

    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void menuGeneral() throws InterruptedException {
        int eleccionG;

        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Insertar a la DB.\n"
                        + "2. Editar la DB.\n"
                        + "3. Eliminar de la DB.\n"
                        + "4. Realizar consultas a la DB.\n"
                        + "5. Salir.\n"
                        + "Elección: ");
                eleccionG = leer.nextInt();

                switch (eleccionG) {
                    case 1:
                        LimpiarAnt.instantaneo();
                        menuInsertar();
                        break;
                    case 2:
                        LimpiarAnt.instantaneo();
                        menuEditar();
                        break;
                    case 3:
                        LimpiarAnt.instantaneo();
                        menuEliminar();
                        break;
                    case 4:
                        LimpiarAnt.instantaneo();
                        menuConsultas();

                        break;
                    case 5:
                        System.out.println("\nGracias por utilizar la libreria virtual!");
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccionG != 5);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            LimpiarAnt.presionar();
        }
    }

    private static void menuInsertar() throws Exception {
        int eleccionI;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Insertar un autor a la DB.\n"
                        + "2. Insertar una editorial a la DB.\n"
                        + "3. Insertar un libro a la DB (autor y editorial necesarios previamente).\n"
                        + "4. Retroceder.\n"
                        + "Elección: ");
                eleccionI = leer.nextInt();

                switch (eleccionI) {
                    case 1:
                        AutorService.crearAutor();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        EditorialService.crearEditorial();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        LibroService.crearLibro();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("El número ingresado no corresponde a ninguna opción");
                        LimpiarAnt.presionar();
                }
            } while (eleccionI != 4);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuEditar() throws Exception {
        int eleccionE;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Modificar el nombre de un autor.\n"
                        + "2. Modificar el nombre de una editorial.\n"
                        + "3. Modificar el titulo de un libro.\n"
                        + "4. Retroceder.\n"
                        + "Elección: ");
                eleccionE = leer.nextInt();
                switch (eleccionE) {
                    case 1:
                        AutorService.modificarNombreAutor();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        EditorialService.modificarNombreEditorial();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        LibroService.modificarTituloLibro();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccionE != 4);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuEliminar() throws Exception {
        int eleccionD;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Eliminar un autor.\n"
                        + "2. Eliminar una editorial.\n"
                        + "3. Eliminar un libro.\n"
                        + "4. Retroceder.\n"
                        + "Elección: ");
                eleccionD = leer.nextInt();
                switch (eleccionD) {
                    case 1:
                        AutorService.eliminarAutor();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        EditorialService.eliminarEditorial();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        LibroService.eliminarLibro();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                        LimpiarAnt.presionar();
                }
            } while (eleccionD != 4);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuConsultas() throws Exception {
        int eleccionC;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Buscar autor por nombre.\n"
                        + "2. Buscar libro por ISBN.\n"
                        + "3. Buscar libro por titulo.\n"
                        + "4. Buscar libro/s por autor.\n"
                        + "5. Buscar libro por editorial\n"
                        + "6. Imprimir autores.\n"
                        + "7. Imprimir autores eliminados.\n"
                        + "8. Imprimir editoriales.\n"
                        + "9. Imprimir editoriales eliminadas.\n"
                        + "10. Imprimir libros.\n"
                        + "11. Imprimir libros eliminados.\n"
                        + "12. Retroceder.\n"
                        + "Elección: ");
                eleccionC = leer.nextInt();

                switch (eleccionC) {
                    case 1:
                        AutorService.imprimirAutorPorNombre();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        LibroService.imprimirLibroPorISBN();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        LibroService.imprimirLibroPorTitulo();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LibroService.imprimirLibrosPorAutor();
                        LimpiarAnt.presionar();
                        break;
                    case 5:
                        LibroService.imprimirLibrosPorEditorial();
                        LimpiarAnt.presionar();
                        break;
                    case 6:
                        AutorService.imprimirAutores();
                        LimpiarAnt.presionar();
                        break;
                    case 7:
                        AutorService.imprimirAutoresEliminados();
                        LimpiarAnt.presionar();
                        break;
                    case 8:
                        EditorialService.imprimirEditoriales();
                        LimpiarAnt.presionar();
                        break;
                    case 9:
                        EditorialService.imprimirEditorialesEliminadas();
                        LimpiarAnt.presionar();
                        break;
                    case 10:
                        LibroService.imprimirLibros();
                        LimpiarAnt.presionar();
                        break;
                    case 11:
                        LibroService.imprimirLibrosEliminados();
                        LimpiarAnt.presionar();
                        break;
                    case 12:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccionC != 12);
        } catch (Exception e) {
            throw e;
        }
    }
}
