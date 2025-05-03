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
         mensaje.append("DATOS DEL CLIENTE: ")
                 .append("ID DEL USUARIO")
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
         mensaje.append("Fecha de inicio: ")
                 .append(prestamo.getFechaDeInicio())
                 .append("\n Fecha de devolución: ")
                 .append(prestamo.getFechaDeDevolucion())
                 .append("\nEstado del prestamo: ")
                 .append(prestamo.getEstado());
         System.out.println(mensaje.toString());
         System.out.println("El prestamo registrado con éxito.");
     }
}
