/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ezequiel
 */
@Entity
public class Editorial implements Serializable {
    @Id
    private Integer id;
    private String nombre;
    private Boolean alta;

    public Editorial() {
        this.alta = true;
    }

    public Editorial(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.alta = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "id: " + id + " || nombre: " + nombre + " || alta: " + alta;
    }

}
