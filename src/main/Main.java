package main;

import administradores.Administrador;
import administradores.RegistrarCliente;
import administradores.RegistrarLibro;
import administradores.RegistrarPrestamo;
import clientes.Cliente;
import libros.Libro;
import prestamos.Prestamo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Administrador admin1 = new Administrador(1, "Omar", "xxx@xxx.com");
        byte opcion = 0;

        do {
            System.out.println(" *********** BIENVENIDOS A LA BIBLIOTECA: MUNDOS MÁGICOS *********** ");
            System.out.println("¿Qué deseas hacer?: ");
            System.out.println("""
                    1. Registrar cliente. \n2. Registrar libro. \n3. Registrar préstamo. \n4. Salir de la biblioteca.
                    """);
            opcion = scanner.nextByte();
            
            switch (opcion){
                case 1: {
                    RegistrarCliente registro = new RegistrarCliente(scanner);
                    Cliente cliente = registro.registrarCliente();
                    admin1.registrarCliente(cliente);
                    break;
                }
                case 2: {
                    RegistrarLibro registro = new RegistrarLibro(scanner);
                    Libro libro = registro.registrarLibro();
                    admin1.registrarLibro(libro);
                    break;
                }
                case 3: {
                    RegistrarPrestamo registro = new RegistrarPrestamo(scanner);
                    Cliente cliente = new Cliente(2, "Ana", "ana@email.com");
                    Libro libro = new Libro("9876543210", "El Principito", "Saint-Exupéry", true);
                    Prestamo prestamo = registro.registrarPrestamo(libro, cliente);
                    admin1.RegistrarPrestamo(prestamo);
                    break;
                }
                case 4: {
                    System.out.println();
                }
                case 5: {
                    System.out.println("Gracias por visitarnos. ¡Hasta pronto!");
                    break;
                }
                default: {
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
                    break;
                }
            }
        }while (opcion != 4);
    }
}