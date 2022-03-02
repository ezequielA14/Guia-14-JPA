package libreria.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ezequiel
 */
@Entity
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucion;
    @OneToOne
    private Libro libro;
    @ManyToOne
    private Cliente cliente;
    private Boolean devuelto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    @Override
    public String toString() {
        return "\nId: " + id + " || Fecha de prestamo: " + fechaPrestamo.getDate() + "/" + (fechaPrestamo.getMonth() + 1) + "/" + (fechaPrestamo.getYear() + 1900)
                + " || Fecha de devolucion: " + fechaDevolucion.getDate() + "/" + (fechaDevolucion.getMonth() + 1) + "/" + (fechaDevolucion.getYear() + 1900)
                + " || Libro: " + libro.getTitulo() + " || Cliente:" + cliente.getNombre() + " || Devuelto: " + devuelto;
    }
}
