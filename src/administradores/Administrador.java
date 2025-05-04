package administradores;

import clientes.Cliente;
import libros.Libro;
import prestamos.Prestamo;
import usuarios.Usuario;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Administrador extends Usuario {
    private ArrayList<Cliente>clientes;
    private ArrayList<Libro>libros;
    private ArrayList<Prestamo>prestamos;

    public Administrador(int id, String nombre, String correo) {
        super(id, nombre, correo);
        this.clientes = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

     public void registrarCliente(ArrayList<Cliente> nuevosClientes){
         for (Cliente c: nuevosClientes){
             this.clientes.add(c);
             System.out.printf("""
                     Clientes registrados: ID: %d, Nombre: %s, Correo: %s%n""",
                     c.getId(), c.getNombre(), c.getCorreo());
         }
         System.out.println("Ha sido registrado con éxito");
     }

     public void registrarLibro(ArrayList<Libro>libros){
         for (Libro l: libros){
             this.libros.add(l);
             System.out.printf("""
                     Libros registrados: ISBN: %s, Título: %s, Autor: %s, Disponible: %b%n""",
                     l.getIsbn(), l.getTitulo(), l.getAutor(), l.getDisponible());
         }
         System.out.println("Libros registrados con éxito.");
     }

     public void RegistrarPrestamo(Prestamo prestamo){
        this.prestamos.add(prestamo);
        prestamo.getLibro().setDisponible(false);
         System.out.printf("""
                 Préstamo: ID del cliente: %d; Título del libro: %s, Autor: %s; Fecha de inicio: %s, Fecha de devolución: %s%n""",
                 prestamo.getUsuario().getId(), prestamo.getLibro().getTitulo(), prestamo.getLibro().getAutor(), prestamo.getFechaDeInicio(), prestamo.getFechaDeDevolucion());
        System.out.println("El préstamo fue registrado con éxito.");
     }
}
