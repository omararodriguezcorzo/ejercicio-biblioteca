package administradores;

import clientes.Cliente;
import libros.Libro;
import prestamos.Prestamo;
import usuarios.Usuario;

public class Administrador extends Usuario {
    public Administrador(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    StringBuilder mensaje = new StringBuilder();

     public void registrarCliente(Cliente cliente){
         mensaje.append("ID DEL USUARIO")
                 .append(cliente.getId())
                 .append("\nNombre del cliente: ")
                 .append(cliente.getNombre())
                 .append("\nCorreo del cliente: ")
                 .append(cliente.getCorreo());
         System.out.println(mensaje.toString());
         System.out.println("Ha sido registrado con éxito");
     }

     public void registrarLibro(Libro libro){
         mensaje.append("ISBN: ")
                 .append(libro.getIsbn())
                 .append("\nTítulo: ")
                 .append(libro.getTitulo())
                 .append("\nAutor: ")
                 .append(libro.getAutor())
                 .append("\nDisponible: ")
                 .append(libro.getDisponible());
         System.out.println(mensaje.toString());
         System.out.println("Libro registrado con éxito.");
     }

     public void RegistrarPrestamo(Prestamo prestamo){
         System.out.println("ISBN: " + prestamo.getLibro().getIsbn() + ".\nTítulo: " + prestamo.getLibro().getTitulo() + ".\nAutor: " + prestamo.getLibro().getAutor() + ".\nDisponible: " + prestamo.getLibro().getDisponible());
         System.out.println("Id: " + prestamo.getUsuario().getId() + ".\nNombre: " + prestamo.getUsuario().getNombre() + ".\nCorreo: " + prestamo.getUsuario().getCorreo());
         System.out.println("Fehca del prestamo: " + prestamo.getFechaDeInicio() + "\nFecha de devolución: " + prestamo.getFechaDeDevolucion());
         System.out.println("El prestamo registrado con éxito.");
     }
}
