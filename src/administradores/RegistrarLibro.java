package administradores;

import libros.Libro;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class RegistrarLibro {
    private Scanner scanner;

    public RegistrarLibro(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Libro> registrarLibro(){
        ArrayList<Libro> libros = new ArrayList<>();

        while (true){
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

            libros.add(new Libro(isbn, titulo, autor, disponible));

            System.out.println("¿Quiere registrar más libros?: ");
            char respuesta = scanner.next().toLowerCase(Locale.ROOT).charAt(0);

            if (respuesta != 's'){
                break;
            }
        }
        return libros;
    }
}
