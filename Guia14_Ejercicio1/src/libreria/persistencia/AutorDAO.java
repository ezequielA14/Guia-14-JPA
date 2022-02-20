/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

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
    
}
