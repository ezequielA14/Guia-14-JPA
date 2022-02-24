package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

/**
 *
 * @author Ezequiel
 */
public class EditorialDAO extends DAO {

    public static void guardarEditorial(Editorial editorial) throws Exception {

        try {

            if (editorial == null) {
                throw new Exception("Debe crear una nueva editorial.");
            }

            guardar(editorial);

        } catch (Exception e) {
            throw e;
        }

    }

    public static void modificarEditorial(Editorial editorial) throws Exception {

        try {

            if (editorial == null) {
                throw new Exception("Debe modificar una editorial válida.");
            }

            editar(editorial);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarEditorial(Editorial editorial) throws Exception {
        try {
            if (editorial == null) {
                throw new Exception("Debe eliminar una editorial válida");
            }

            eliminar(editorial);

        } catch (Exception e) {
            throw e;
        }
    }

    public static Editorial buscarEditorialPorId(Integer id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

    public static Editorial buscarEditorialPorNombre(String nombre) {
        conectar();
        Editorial editorial = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre", Editorial.class).setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;
    }

    public static List<Editorial> listarEditoriales() throws Exception {
        try {
            conectar();
            List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.alta = true", Editorial.class).getResultList();
            desconectar();

            return editoriales;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    public static List<Editorial> listarEditorialesEliminadas() throws Exception {
        try {
            conectar();
            List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.alta = false", Editorial.class).getResultList();
            desconectar();

            return editoriales;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
}
