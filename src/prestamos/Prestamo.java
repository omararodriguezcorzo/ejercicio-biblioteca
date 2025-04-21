package prestamos;

import libros.Libro;
import usuarios.Usuario;

import java.util.Date;

public class Prestamo {
    private Date fechaDeInicio;
    private Date fechaDeDevolucion;
    private String estado;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(Date fechaInicio, Date fechaDeDevolucion, String estado, Libro libro, Usuario usuario) {
        this.fechaDeInicio = fechaInicio;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.estado = estado;
        this.libro = libro;
        this.usuario = usuario;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Date getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(Date fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
