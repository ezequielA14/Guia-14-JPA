package libreria;

import limpiarPantalla.LimpiarAnt;
import java.util.Scanner;
import libreria.servicios.*;

/**
 *
 * @author Ezequiel
 */
public class Menu {

    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void menuGeneral() throws InterruptedException {
        int eleccion;

        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Insertar a la DB.\n"
                        + "2. Editar la DB.\n"
                        + "3. Eliminar de la DB.\n"
                        + "4. Realizar consultas a la DB.\n"
                        + "5. Salir.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
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
                        menuConsultasGeneral();
                        break;
                    case 5:
                        System.out.println("\nGracias por utilizar la libreria virtual!");
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 5);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            LimpiarAnt.presionar();
            menuGeneral();
        }
    }

    private static void menuInsertar() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Insertar un autor a la DB.\n"
                        + "2. Insertar una editorial a la DB.\n"
                        + "3. Insertar un cliente a la DB.\n"
                        + "4. Insertar un libro a la DB.\n"
                        + "5. Insertar un prestamo a la DB.\n"
                        + "6. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
                    case 1:
                        AutorService.crearAutor();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        EditorialService.crearEditorial();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        ClienteService.crearCliente();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LibroService.crearLibro();
                        LimpiarAnt.presionar();
                        break;
                    case 5:
                        PrestamoService.crearPrestamo();
                        LimpiarAnt.presionar();
                        break;
                    case 6:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("El número ingresado no corresponde a ninguna opción");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 6);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuEditar() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Modificar el nombre de un autor.\n"
                        + "2. Modificar el nombre de una editorial.\n"
                        + "3. Modificar el titulo de un libro.\n"
                        + "4. Modificar el nombre de un cliente.\n"
                        + "5. Modificar la fecha de devolución de un prestamo.\n"
                        + "6. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();
                switch (eleccion) {
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
                        ClienteService.modificarNombreCliente();
                        LimpiarAnt.presionar();
                        break;
                    case 5:
                        PrestamoService.modificarFechaDevolucionPrestamo();
                        LimpiarAnt.presionar();
                        break;
                    case 6:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 6);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuEliminar() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Eliminar un autor.\n"
                        + "2. Eliminar una editorial.\n"
                        + "3. Eliminar un libro.\n"
                        + "4. devolver un prestamo.\n"
                        + "5. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();
                switch (eleccion) {
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
                        PrestamoService.devolverPrestamo();
                        LimpiarAnt.presionar();
                        break;
                    case 5:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 5);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuConsultasGeneral() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Consultas de autores.\n"
                        + "2. Consultas de editoriales.\n"
                        + "3. Consultas de libros.\n"
                        + "4. Consultas de prestamos.\n"
                        + "5. Consultas de clientes.\n"
                        + "6. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
                    case 1:
                        LimpiarAnt.instantaneo();
                        menuConsultasAutor();
                        break;
                    case 2:
                        LimpiarAnt.instantaneo();
                        menuConsultasEditorial();
                        break;
                    case 3:
                        LimpiarAnt.instantaneo();
                        menuConsultasLibro();
                        break;
                    case 4:
                        LimpiarAnt.instantaneo();
                        menuConsultasPrestamo();
                        break;
                    case 5:
                        LimpiarAnt.instantaneo();
                        menuConsultasCliente();
                        break;
                    case 6:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 6);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuConsultasAutor() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Buscar autor por nombre.\n"
                        + "2. Imprimir autores.\n"
                        + "3. Imprimir autores eliminados.\n"
                        + "4. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
                    case 1:
                        AutorService.imprimirAutorPorNombre();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        AutorService.imprimirAutores();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        AutorService.imprimirAutoresEliminados();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 4);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuConsultasEditorial() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Buscar editorial por nombre.\n"
                        + "2. Imprimir editoriales.\n"
                        + "3. Imprimir editoriales eliminadas.\n"
                        + "4. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
                    case 1:
                        EditorialService.imprimirEditorialPorNombre();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        EditorialService.imprimirEditoriales();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        EditorialService.imprimirEditorialesEliminadas();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 4);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void menuConsultasLibro() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Buscar libro por ISBN.\n"
                        + "2. Buscar libro por titulo.\n"
                        + "3. Buscar libro/s por autor.\n"
                        + "4. Buscar libro/s por editorial\n"
                        + "5. Imprimir libros.\n"
                        + "6. Imprimir libros eliminados.\n"
                        + "7. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
                    case 1:
                        LibroService.imprimirLibroPorISBN();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        LibroService.imprimirLibroPorTitulo();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        LibroService.imprimirLibrosPorAutor();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        LibroService.imprimirLibrosPorEditorial();
                        LimpiarAnt.presionar();
                        break;
                    case 5:
                        LibroService.imprimirLibros();
                        LimpiarAnt.presionar();
                        break;
                    case 6:
                        LibroService.imprimirLibrosEliminados();
                        LimpiarAnt.presionar();
                        break;
                    case 7:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 7);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void menuConsultasPrestamo() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Buscar prestamo por id.\n"
                        + "2. Buscar prestamo/s por documento de cliente .\n"
                        + "3. Imprimir prestamos.\n"
                        + "4. Imprimir prestamos devueltos.\n"
                        + "5. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
                    case 1:
                        PrestamoService.imprimirPrestamoPorId();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        PrestamoService.imprimirPrestamosPorDocumentoCliente();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        PrestamoService.imprimirPrestamos();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        PrestamoService.imprimirPrestamosDevueltos();
                        LimpiarAnt.presionar();
                        break;
                    case 5:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 5);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void menuConsultasCliente() throws Exception {
        int eleccion;
        try {
            do {
                System.out.print("ELIJA UNA DE LAS SIGUIENTES OPCIONES NÚMERICAS\n"
                        + "1. Buscar cliente por documento.\n"
                        + "2. Buscar cliente/s por nombre.\n"
                        + "3. Buscar cliente/s por apellido.\n"
                        + "4. Imprimir clientes.\n"
                        + "5. Retroceder.\n"
                        + "Elección: ");
                eleccion = leer.nextInt();

                switch (eleccion) {
                    case 1:
                        ClienteService.imprimirClientePorDocumento();
                        LimpiarAnt.presionar();
                        break;
                    case 2:
                        ClienteService.imprimirClientesPorNombre();
                        LimpiarAnt.presionar();
                        break;
                    case 3:
                        ClienteService.imprimirClientesPorApellido();
                        LimpiarAnt.presionar();
                        break;
                    case 4:
                        ClienteService.imprimirClientes();
                        LimpiarAnt.presionar();
                        break;
                    case 5:
                        LimpiarAnt.instantaneo();
                        break;
                    default:
                        System.out.println("\nEl número ingresado no corresponde a ninguna opción\n");
                        LimpiarAnt.presionar();
                }
            } while (eleccion != 5);
        } catch (Exception e) {
            throw e;
        }
    }
}
