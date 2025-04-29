package administradores;

import clientes.Cliente;
import libros.Libro;
import prestamos.Prestamo;
import usuarios.Usuario;

import java.util.HashMap;

public class Administrador extends Usuario {
    private HashMap<Integer, Cliente> clientes = new HashMap<>();
    private HashMap<String, Libro> libros = new HashMap<>();
    private HashMap<Integer, Prestamo> prestamos = new HashMap<>();
    private int contadorPrestamos = 0;

    public Administrador(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    StringBuilder mensaje = new StringBuilder();

     public void registrarCliente(Cliente cliente){
         clientes.put(cliente.getId(), cliente);
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
         libros.put(libro.getIsbn(), libro);
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
         contadorPrestamos++;
         prestamos.put(contadorPrestamos, prestamo);
         mensaje.append("DATOS DEL PRÉSTAMO:\n")
                 // DATOS DEL LIBRO
                 .append("\nISBN: ").append(prestamo.getLibro().getIsbn())
                 .append("\nTítulo: ").append(prestamo.getLibro().getTitulo())
                 .append("\nAutor: ").append(prestamo.getLibro().getAutor())
                 .append("\nDisponible: ").append(prestamo.getLibro().getDisponible())
                 // DATOS DEL CLIENTE
                 .append("\nCliente ID: ").append(prestamo.getUsuario().getId())
                 .append("\nCliente Nombre: ").append(prestamo.getUsuario().getNombre())
                 .append("\nCorreo Cliente: ").append(prestamo.getUsuario().getCorreo())
                 // DATOS DEL PRESTAMOS
                 .append("\nFecha de inicio: ").append(prestamo.getFechaDeInicio())
                 .append("\nFecha de devolución: ").append(prestamo.getFechaDeDevolucion())
                 .append("ID Préstamo: ").append(contadorPrestamos);
         System.out.println(mensaje.toString());
         System.out.println("El préstamo fue registrado con éxito.");
     }
}
