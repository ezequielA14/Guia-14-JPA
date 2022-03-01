package libreria.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.ClienteDAO;
import libreria.persistencia.LibroDAO;
import libreria.persistencia.PrestamoDAO;

/**
 * @author Ezequiel
 */
public class PrestamoService {

    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void crearPrestamo() throws Exception {
        /// Crea un formato de fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            /// guardamos la fecha actual para comparar con la de devolución
            Date fechaActual = new Date();
            /// lo dividimos en dias, meses y años para guardarlos en un String ordenados y el formato.parse funcione
            int[] date = {fechaActual.getDate(), fechaActual.getMonth() + 1, fechaActual.getYear() + 1900};
            /// Hacemos un string con la fecha y el formato correspondiente
            String fechaActSt = date[0] + "/" + date[1] + "/" + date[2];
            fechaActual = formato.parse(fechaActSt);
            System.out.println("La fecha actual es: " + fechaActSt);
            
            /// Le pide la fecha de devolución como String al usuario
            System.out.print("Ingrese la fecha de devolucion: ");
            String fechaDevSt = leer.next();

            /// Valida que la fecha no esté vacia
            if (fechaDevSt == null || fechaDevSt.trim().isEmpty()) {
                throw new Exception("La fecha no puede estar vacia");
            }
            
            /// Parsea la fecha de String a Date.
            Date fechaDevolucion = formato.parse(fechaDevSt);
            
            /// Valida que el usuario ingrese una fecha posterior a la actual
            if (fechaDevolucion.before(fechaActual)) {
                throw new Exception("La fecha de devolucion no puede ser anterior a la actual");
            }

            /// Le pide el título del libro al usuario
            System.out.print("Ingrese el titulo del libro del prestamo: ");
            String titulo = leer.next();

            /// Valida que el título no esté vacio
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe ingresar un titulo valido");
            }

            /// Busca el libro según el titulo y lo guarda en una instancia de libro
            Libro libro = LibroDAO.buscarLibroPorTitulo(titulo);

            /// Valida que la instancia de libro no sea null
            if (libro == null) {
                throw new Exception("El libro no existe en la base de datos");
            }

            /// Le pide el documento del cliente al usuario
            System.out.print("Ingrese el documento del cliente: ");
            Long documento = leer.nextLong();

            /// Valida que el documento ingresado no sea un número negativo
            if (documento <= 0) {
                throw new Exception("Debe ingresar un documento válido");
            }

            /// Busca al cliente según el documento y lo guarda en una instancia de cliente
            Cliente cliente = ClienteDAO.buscarClientePorDocumento(documento);

            /// Valida que cliente no sea null
            if (cliente == null) {
                throw new Exception("El cliente no existe en la base de datos");
            }

            Prestamo prestamo = new Prestamo();
            prestamo.setFechaPrestamo(fechaActual);
            prestamo.setFechaDevolucion(fechaDevolucion);
            prestamo.setLibro(libro);
            prestamo.setCliente(cliente);
            prestamo.setDevuelto(Boolean.FALSE);
            PrestamoDAO.guardarPrestamo(prestamo);
        } catch (ParseException e) {
            System.out.println("El formato de fecha introducido es incorrecto, debe respetar el siguiente formato: dd/mm/yyyy");
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void modificarFechaDevolucionPrestamo() throws Exception {

    }

    public static void devolverPrestamo() throws Exception {
        try {
            System.out.println("Ingrese el id del prestamo que va a devolver");
            Integer id = leer.nextInt();

            if (id <= 0) {
                throw new Exception("Debe indicar un id válido");
            }

            Prestamo prestamo = PrestamoDAO.buscarPrestamoPorId(id);

            if (prestamo == null) {
                throw new Exception("No existe ningún prestamo con ese id");
            }

            prestamo.setDevuelto(Boolean.TRUE);
            PrestamoDAO.modificarPrestamo(prestamo);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirPrestamoPorId() throws Exception {
        try {
            System.out.print("Ingrese el id del prestamo: ");
            Integer id = leer.nextInt();

            if (id <= 0) {
                throw new Exception("Debe indicar un id válido");
            }

            Prestamo prestamo = PrestamoDAO.buscarPrestamoPorId(id);

            if (prestamo == null) {
                throw new Exception("No existe ningún prestamo con ese id");
            }

            System.out.println(prestamo);
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
    
    public static void imprimirPrestamosPorDocumentoCliente() throws Exception {
        try {
            System.out.print("Ingrese el documento del cliente: ");
            Long documento = leer.nextLong();
            
            if (documento <= 0) {
                throw new Exception("Debe indicar un documento válido");
            }
            if (ClienteDAO.buscarClientePorDocumento(documento) == null) {
                throw new Exception("No existe ningun cliente con ese documento");
            }
            
            List<Prestamo> prestamos = PrestamoDAO.buscarPrestamosPorDocumentoCliente(documento);

            if (prestamos.isEmpty()) {
                throw new Exception("No hay prestamos para imprimir");
            }

            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
    
    public static void imprimirPrestamos() throws Exception {
        try {
            List<Prestamo> prestamos = PrestamoDAO.listarPrestamos();

            if (prestamos.isEmpty()) {
                throw new Exception("No hay prestamos para imprimir");
            }

            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirPrestamosDevueltos() throws Exception {
        try {
            List<Prestamo> prestamos = PrestamoDAO.listarPrestamosDevueltos();

            if (prestamos.isEmpty()) {
                throw new Exception("No hay prestamos para imprimir");
            }

            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}
