package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;
import static libreria.persistencia.DAO.guardar;

/**
 *
 * @author Ezequiel
 */
public class AutorDAO extends DAO {

    public static void guardarAutor(Autor autor) throws Exception {

        try {

            if (autor == null) {
                throw new Exception("Debe crear un nuevo autor.");
            }

            guardar(autor);

        } catch (Exception e) {
            throw e;
        }

    }

    public static void modificarAutor(Autor autor) throws Exception {

        try {

            if (autor == null) {
                throw new Exception("Debe modificar un autor válido.");
            }

            editar(autor);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarAutor(Autor autor) throws Exception {
        try {
            if (autor == null) {
                throw new Exception("Debe eliminar un autor válido");
            }

            eliminar(autor);

        } catch (Exception e) {
            throw e;
        }
    }

    public static Autor buscarAutorPorId(Integer id) {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }

    public static Autor buscarAutorPorNombre(String nombre) throws Exception {
        try {
            conectar();
            Autor autor = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre", Autor.class).setParameter("nombre", nombre).getSingleResult();
            desconectar();
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<Autor> listarAutores() {
        try {
            conectar();
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.alta = true", Autor.class).getResultList();
            desconectar();

            return autores;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    public static List<Autor> listarAutoresEliminados() {
        try {
            conectar();
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.alta = false", Autor.class).getResultList();
            desconectar();

            return autores;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

}
