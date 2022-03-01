package libreria.persistencia;

import java.util.List;
import libreria.entidades.Prestamo;

/**
 * @author Ezequiel
 */
public class PrestamoDAO extends DAO {

    public static void guardarPrestamo(Prestamo prestamo) throws Exception {

        try {

            if (prestamo == null) {
                throw new Exception("Debe crear un nuevo prestamo.");
            }

            guardar(prestamo);

        } catch (Exception e) {
            throw e;
        }

    }

    public static void modificarPrestamo(Prestamo prestamo) throws Exception {

        try {

            if (prestamo == null) {
                throw new Exception("Debe modificar un prestamo válido.");
            }

            editar(prestamo);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarPrestamo(Prestamo prestamo) throws Exception {
        try {
            if (prestamo == null) {
                throw new Exception("Debe eliminar un cliente válido");
            }

            eliminar(prestamo);

        } catch (Exception e) {
            throw e;
        }
    }

    public static Prestamo buscarPrestamoPorId(Integer id) throws Exception {
        try {
            conectar();
            Prestamo prestamo = em.find(Prestamo.class, id);
            desconectar();
            return prestamo;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Prestamo> buscarPrestamosPorDocumentoCliente(Long documento) throws Exception {
        try {
            conectar();
            List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.documento = :documento", Prestamo.class).setParameter("documento", documento).getResultList();
            desconectar();
            return prestamos;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Prestamo> listarPrestamos() throws Exception {
        try {
            conectar();
            List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.devuelto = false", Prestamo.class).getResultList();
            desconectar();

            return prestamos;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public static List<Prestamo> listarPrestamosDevueltos() throws Exception {
        try {
            conectar();
            List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.devuelto = true", Prestamo.class).getResultList();
            desconectar();

            return prestamos;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

}
