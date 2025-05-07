package main;

import administradores.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registros registro = new Registros(scanner);

        Administrador admin1 = new Administrador(1, "Xxxxx Xxxxx", "xxx@xxx.xxx");
        byte opcion = 0;

        do {
            System.out.println(" *********** BIENVENIDOS A LA BIBLIOTECA: MUNDOS MÁGICOS *********** ");
            System.out.println("¿Qué deseas hacer?: ");
            System.out.print(""" 
                    1. Registrar cliente.
                    2. Registrar libro.
                    3. Registrar préstamo.
                    4. Salir de la biblioteca.
                    """);
            opcion = scanner.nextByte();
            scanner.nextLine();
            
            switch (opcion){
                case 1 -> {
                    var clientes = registro.registrarClientes();
                    admin1.registrarCliente(clientes);
                }
                case 2 -> {
                    var libros = registro.registrarLibro();
                    admin1.registrarLibro(libros);
                }
                case 3 -> {
                    var prestamo = registro.registrarPrestamo(admin1.getClientes(), admin1.getLibros());
                    if (prestamo != null){
                        admin1.RegistrarPrestamo(prestamo);
                    }else {
                        System.out.println("Préstamo cancelado.");
                    }
                }
                case 4-> System.out.println("Gracias por visitarnos. ¡Hasta pronto!");

                default -> System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
            }
        }while (opcion != 4);
        scanner.close();
    }
}