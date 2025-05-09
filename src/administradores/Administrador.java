package administradores;

import clientes.Cliente;
import libros.Libro;
import prestamos.Prestamo;
import usuarios.Usuario;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {
    private List<Cliente>clientes;
    private List<Libro>libros;
    private List<Prestamo>prestamos;

    public Administrador(int id, String nombre, String correo) {
        super(id, nombre, correo);
        this.clientes = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

     public void registrarCliente(List<Cliente> clientes){
        this.clientes.addAll(clientes);
         System.out.println("Cliente/s registrado/s: ");
         for (Cliente c: clientes){
             System.out.printf("""
                     \tID: %d, Nombre: %s, Correo: %s%n""",
                     c.getId(), c.getNombre(), c.getCorreo());
         }
         System.out.println("Ha sido registrado con éxito");
     }

     public void registrarLibro(List<Libro>libros){
        this.libros.addAll(libros);
         System.out.println("Libro/s registrado/s: ");
         for (Libro l: libros){
             System.out.printf("""
                             \tISBN: %s, Título: %s, Autor: %s, Disponible: %b
                             """,
                            l.getIsbn(), l.getTitulo(), l.getAutor(), l.getDisponible());
         }
         System.out.println("Libros registrados con éxito.");
     }

     public void RegistrarPrestamo(Prestamo prestamo){
        this.prestamos.add(prestamo);
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        prestamo.getLibro().setDisponible(false);
        System.out.println("----- PRÉSTAMO REALIZADO CON ÉXITO -----");
        System.out.printf("""
                ID del cliente: %d;
                Título del libro: %s
                Autor: %s
                Fecha de inicio: %s
                Fecha de devolución: %s
                Estado del préstamo: %s%n
                """,
                 prestamo.getUsuario().getId(),
                 prestamo.getLibro().getTitulo(),
                 prestamo.getLibro().getAutor(),
                 prestamo.getFechaDeInicio().format(formatoFecha),
                 prestamo.getFechaDeDevolucion().format(formatoFecha),
                 prestamo.getEstado());
        System.out.println("El préstamo fue registrado con éxito.");
     }
     public List<Cliente> getClientes(){
        return clientes;
     }

    public List<Libro> getLibros() { return libros; }
    public List<Prestamo> getPrestamos(){
        return prestamos;
    }
}