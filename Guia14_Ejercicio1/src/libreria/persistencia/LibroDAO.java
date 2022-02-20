/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.ArrayList;
import libreria.entidades.Libro;

/**
 *
 * @author Ezequiel
 */
public class LibroDAO extends DAO {

    public static void guardarLibro(Libro libro) throws Exception {

        try {

            if (libro == null) {
                throw new Exception("Debe crear un nuevo libro.");
            }

            guardar(libro);

        } catch (Exception e) {
            throw e;
        }

    }

    public static void modificarLibro(Libro libro) throws Exception {

        try {

            if (libro == null) {
                throw new Exception("Debe modificar un libro válido.");
            }

            editar(libro);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarLibro(Libro libro) throws Exception {
        try {
            if (libro == null) {
                throw new Exception("Debe eliminar un libro válido");
            }

            eliminar(libro);

        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Libro> listarLibros() {
        try {
            conectar();
            ArrayList<Libro> libros = (ArrayList) em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
            desconectar();

            return libros;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public static Libro buscarLibroPorISBN(Long isbn) {
        try {
            conectar();
            Libro libro = em.find(Libro.class, isbn);
            desconectar();
            return libro;
        } catch (Exception e) {
            throw e;
        }

    }

    public static Libro buscarLibroPorTitulo(String titulo) {
        try {
            conectar();
            Libro libro = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class).setParameter("titulo", titulo).getSingleResult();
            desconectar();
            return libro;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Libro> buscarLibrosPorAutor(String autor) {
        try {
            conectar();
            ArrayList<Libro> libros = (ArrayList) em.createQuery("SELECT l from Libro l WHERE l.autor.nombre LIKE :autor", Libro.class).setParameter("autor", autor).getResultList();
            desconectar();
            return libros;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Libro> buscarLibrosPorEditorial(String editorial) {
        try {
            conectar();
            ArrayList<Libro> libros = (ArrayList) em.createQuery("SELECT l from Libro l WHERE l.editorial.nombre LIKE :editorial", Libro.class).setParameter("editorial", editorial).getResultList();
            desconectar();
            return libros;
        } catch (Exception e) {
            throw e;
        }
    }

}
