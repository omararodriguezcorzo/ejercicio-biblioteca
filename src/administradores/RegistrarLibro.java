package administradores;

import libros.Libro;

import java.util.Scanner;

public class RegistrarLibro {
    private Scanner scanner;

    public RegistrarLibro(Scanner scanner) {
        this.scanner = scanner;
    }

    public Libro registrarLibro(){
        System.out.println("---------------- REGISTRO PARA LIBRO ----------------");

        scanner.nextLine();

        System.out.print("Ingrese el ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Ingrese título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();

        System.out.print("Está disponible: ");
        boolean disponible = scanner.nextBoolean();

        return new Libro(isbn, titulo, autor, disponible);
    }
}
