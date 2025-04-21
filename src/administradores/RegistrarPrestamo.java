package administradores;

import libros.Libro;
import prestamos.Prestamo;
import usuarios.Usuario;
import utilidades.ObtenerFecha;

import java.util.Date;
import java.util.Scanner;

public class RegistrarPrestamo {
    private Scanner scanner;

    public RegistrarPrestamo(Scanner scanner) {
        this.scanner = scanner;
    }

    public Prestamo registrarPrestamo(Libro libro, Usuario usuario){
        System.out.println("---------------- REGISTRO PARA PRÉSTAMO ----------------");

        scanner.nextLine();

        System.out.print("Ingrese fecha de devolución (dd/MM/yyyy): ");
        String fechaDeEntrega= scanner.nextLine();

        Date fechaInicio = new Date();
        Date fechaDeDevolucion = ObtenerFecha.formatearFecha(fechaDeEntrega);

        System.out.print("Estádo prestamos (Activo/Entregado): ");
        String estado = scanner.nextLine();

        return new Prestamo(fechaInicio, fechaDeDevolucion, estado, libro, usuario);
    }
}
