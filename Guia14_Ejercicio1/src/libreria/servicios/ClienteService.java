package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

/**
 * @author Ezequiel
 */
public class ClienteService {

    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public static void crearCliente() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            /// Le pide el número de documento del cliente al usuario
            System.out.print("Ingrese el número de documento del cliente: ");
            Long documento = leer.nextLong();

            /// Valida que el documento no sea un número negativo o cero
            if (documento == null || documento <= 0) {
                throw new Exception("Debe ingresar un documento para el cliente.");
            }

            /// Valida que no exista ningún cliente con ese documento
            if (ClienteDAO.buscarClientePorDocumento(documento) != null) {
                throw new Exception("Ya hay un cliente con ese número de documento en la base de datos");
            }

            /// Le pide al usuario el nombre del cliente
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = leer.next();

            /// Valida que el nombre no esté vacio
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre para el cliente.");
            }

            /// Le pide al usuario el apellido del cliente
            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = leer.next();

            /// Valida que el apellido no esté vacío
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("Debe ingresar un apellido para el cliente.");
            }

            /// Le pide al usuario el número de telefono del cliente
            System.out.print("Ingrese el número de telefono: ");
            String telefono = leer.next();

            /// Valida que el número de telefono no esté vacío
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new Exception("Debe ingresar un número de telefono válido.");
            }

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDocumento(documento);
            cliente.setTelefono(telefono);
            ClienteDAO.guardarCliente(cliente);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void modificarNombreCliente() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            /// Le pide al usuario el documento del cliente que quiere editar
            System.out.print("Ingrese el documento del cliente que desea editar: ");
            Long documento = leer.nextLong();

            /// Valida que el documento no sea un número negativo o cero
            if (documento == null || documento <= 0) {
                throw new Exception("Debe de indicar un documento válido");
            }

            /// Le pide al usuario el nuevo nombre del cliente
            System.out.print("Ingrese el nuevo nombre del cliente: ");
            String nombreNuevo = leer.next();

            /// Valida que el nuevo nombre no esté vacio
            if (nombreNuevo == null || nombreNuevo.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre válido");
            }

            Cliente cliente = ClienteDAO.buscarClientePorDocumento(documento);
            cliente.setNombre(nombreNuevo);
            ClienteDAO.modificarCliente(cliente);

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
    
    public static void imprimirClientePorDocumento() {
        try {
            System.out.print("Ingrese el documento del cliente: ");
            Long documento = leer.nextLong();

            if (documento == null || documento <= 0) {
                throw new Exception("Debe indicar un documento válido");
            }

            Cliente cliente = ClienteDAO.buscarClientePorDocumento(documento);

            if (cliente == null) {
                throw new Exception("No existe ningún cliente con ese documento");
            }

            System.out.println(cliente);
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void imprimirClientes() throws Exception {
        try {
            List<Cliente> clientes = ClienteDAO.listarClientes();

            if (clientes.isEmpty()) {
                throw new Exception("No hay clientes para imprimir");
            }

            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
    
    public static void imprimirClientesPorNombre() throws Exception {
        try {
            System.out.println("Ingrese el nombre de los clientes a buscar: ");
            String nombre = leer.next();
            List<Cliente> clientes = ClienteDAO.listarClientesPorNombre(nombre);

            if (clientes.isEmpty()) {
                throw new Exception("No hay clientes para imprimir");
            }

            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
    
    public static void imprimirClientesPorApellido() throws Exception {
        try {
            System.out.println("Ingrese el apellido de los clientes a buscar: ");
            String apellido = leer.next();
            List<Cliente> clientes = ClienteDAO.listarClientesPorApellido(apellido);

            if (clientes.isEmpty()) {
                throw new Exception("No hay clientes para imprimir");
            }

            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}
