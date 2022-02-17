/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Autor;

/**
 *
 * @author Ezequiel
 */
public class AutorService {

    public static void crearAutor() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            Autor autor = new Autor();
            System.out.print("Ingrese el ID del autor: ");
            autor.setId(leer.nextInt());
            System.out.print("Ingrese el nombre del autor: ");
            autor.setNombre(leer.next());
            
            guardarAutor(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void guardarAutor(Autor autor) {

    }

}
