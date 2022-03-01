package libreria.persistencia;

import java.util.List;
import libreria.entidades.Cliente;

/**
 * @author Ezequiel
 */
public class ClienteDAO extends DAO {

    public static void guardarCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe crear un nuevo cliente.");
            }
            guardar(cliente);
        } catch (Exception e) {
            throw e;
        }

    }

    public static void modificarCliente(Cliente cliente) throws Exception {

        try {

            if (cliente == null) {
                throw new Exception("Debe modificar un cliente válido.");
            }

            editar(cliente);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe eliminar un cliente válido");
            }

            eliminar(cliente);

        } catch (Exception e) {
            throw e;
        }
    }

    public static Cliente buscarClientePorId(Integer id) throws Exception {
        try {
            conectar();
            Cliente cliente = em.find(Cliente.class, id);
            desconectar();
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    public static Cliente buscarClientePorDocumento(Long documento) throws Exception {
        try {
            conectar();
            Cliente cliente = em.createQuery("SELECT c FROM Cliente c WHERE c.documento = :documento", Cliente.class).setParameter("documento", documento).getSingleResult();
            desconectar();
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Cliente> listarClientes() throws Exception {
        try {
            conectar();
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            desconectar();

            return clientes;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public static List<Cliente> listarClientesPorNombre(String nombre) throws Exception {
        try {
            conectar();
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre", Cliente.class).setParameter("nombre", "%" + nombre + "%").getResultList();
            desconectar();

            return clientes;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public static List<Cliente> listarClientesPorApellido(String apellido) throws Exception {
        try {
            conectar();
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.apellido LIKE :apellido", Cliente.class).setParameter("apellido", "%" + apellido + "%").getResultList();
            desconectar();

            return clientes;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
}
