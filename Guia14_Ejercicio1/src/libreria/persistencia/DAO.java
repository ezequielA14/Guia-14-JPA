package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ezequiel
 */
public class DAO {

    protected static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Guia14_Ejercicio1PU");
    protected static EntityManager em = EMF.createEntityManager();

    protected static void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected static void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected static void guardar(Object objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected static void editar(Object objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected static void eliminar(Object objeto) {
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
