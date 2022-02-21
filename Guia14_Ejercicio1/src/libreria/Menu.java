package libreria;

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
                        LimpiarPantalla.limpiarAntInstantaneo();
                        menuInsertar();
                        break;
                    case 2:
                        LimpiarPantalla.limpiarAntInstantaneo();
                        menuEditar();
                        break;
                    case 3:
                        LimpiarPantalla.limpiarAntInstantaneo();
                        menuEliminar();
                        break;
                    case 4:
                        LimpiarPantalla.limpiarAntInstantaneo();
                        menuConsultas();
                        
                        break;
                    case 5:
                        System.out.println("\nGracias por utilizar la libreria virtual!");
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarPantalla.limpiarAnt();
                }
            } while (eleccionG != 5);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            LimpiarPantalla.limpiarAnt();
            menuGeneral();
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
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 2:
                        EditorialService.crearEditorial();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 3:
                        LibroService.crearLibro();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 4:
                        LimpiarPantalla.limpiarAntInstantaneo();
                        break;
                    default:
                        System.out.println("El número ingresado no corresponde a ninguna opción");
                        LimpiarPantalla.limpiarAnt();
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
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 2:
                        EditorialService.modificarNombreEditorial();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 3:
                        LibroService.modificarTituloLibro();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 4:
                        LimpiarPantalla.limpiarAntInstantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarPantalla.limpiarAnt();
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
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 2:
                        EditorialService.eliminarEditorial();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 3:
                        LibroService.eliminarLibro();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 4:
                        LimpiarPantalla.limpiarAntInstantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarPantalla.limpiarAnt();
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
                        + "7. Imprimir editoriales.\n"
                        + "8. Imprimir libros.\n"
                        + "9. Retroceder.\n"
                        + "Elección: ");
                eleccionC = leer.nextInt();

                switch (eleccionC) {
                    case 1:
                        AutorService.imprimirAutorPorNombre();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 2:
                        LibroService.imprimirLibroPorISBN();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 3:
                        LibroService.imprimirLibroPorTitulo();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 4:
                        LibroService.imprimirLibrosPorAutor();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 5:
                        LibroService.imprimirLibrosPorEditorial();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 6:
                        AutorService.imprimirAutores();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 7:
                        EditorialService.imprimirEditoriales();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 8:
                        LibroService.imprimirLibros();
                        LimpiarPantalla.limpiarAnt();
                        break;
                    case 9:
                        LimpiarPantalla.limpiarAntInstantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarPantalla.limpiarAnt();
                }
            } while (eleccionC != 9);
        } catch (Exception e) {
            throw e;
        }
    }
}
