package prestamos;

import libros.Libro;
import usuarios.Usuario;

import java.time.LocalDateTime;
import java.util.Date;

public class Prestamo {
    private LocalDateTime fechaDeInicio;
    private LocalDateTime fechaDeDevolucion;
    private boolean estado;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(LocalDateTime fechaInicio, LocalDateTime fechaDeDevolucion, boolean estado, Libro libro, Usuario usuario) {
        this.fechaDeInicio = fechaInicio;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.estado = estado;
        this.libro = libro;
        this.usuario = usuario;
    }

    public LocalDateTime getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDateTime fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public LocalDateTime getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(LocalDateTime fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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
