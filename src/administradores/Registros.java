package administradores;

import clientes.Cliente;
import libros.Libro;
import prestamos.Prestamo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Registros {
    private Scanner scanner;
    int contador = 1;

    public Registros(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Cliente> registrarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        while (true) {
            System.out.println("---------------- REGISTRO PARA CLIENTE ----------------");
            int id = contador++;

            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingre el correo: ");
            String correo = scanner.nextLine();

            clientes.add(new Cliente(id, nombre, correo));

            System.out.println("¿Quieres registrar más cliente? (s/n): ");
            char respuesta = scanner.next().toLowerCase(Locale.ROOT).charAt(0);
            if (respuesta != 's') break;
            scanner.nextLine();
        }
        return clientes;
    }

    public List<Libro> registrarLibro() {
        List<Libro> libros = new ArrayList<>();

        while (true) {
            System.out.println("---------------- REGISTRO PARA LIBROS ----------------");

            System.out.print("Ingrese el ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Ingrese el título: ");
            String titulo = scanner.nextLine();

            System.out.print("Ingrese el autor: ");
            String autor = scanner.nextLine();

            System.out.print("¿Está diponible?: ");
            boolean disponible = scanner.nextBoolean();
            scanner.nextLine();

            libros.add(new Libro(isbn, titulo, autor, disponible));

            System.out.println("¿Quiere registrr más libros? (s/n): ");
            char respuesta = scanner.next().toLowerCase(Locale.ROOT).charAt(0);
            if (respuesta != 's') break;
            scanner.nextLine();
        }
        return libros;
    }

    public Prestamo registrarPrestamo(List<Cliente> clientes, List<Libro> libros) {
        System.out.println("---------------- REGISTRO PARA PRÉSTAMO ----------------");

        if (clientes.isEmpty() || libros.stream().noneMatch(Libro::getDisponible)) {
            System.out.println("No hay usuarios o libros disponibles para asignar un préstamo.");
            return null;
        }

        Cliente cliente = seleccionarCliente(clientes);
        if (cliente == null) return null;

        Libro libro = seleccionarLibro(libros);
        if (libro == null) return null;

        LocalDateTime fechaDeInicio = LocalDateTime.now();
        LocalDateTime fechaDeDevolucion = fechaDeInicio.plusDays(14);
        libro.setDisponible(false);
        boolean estado = true;

        return new Prestamo(fechaDeInicio, fechaDeDevolucion, estado, libro, cliente);
    }

    private Libro seleccionarLibro(List<Libro> libros) {
        while (true) {
            System.out.println("----- Búsqueda de libro -----");
            System.out.print("""
                    1. Buscar por titulo
                    2. Buscar por autor
                    0. Cancelar préstamo
                    """);
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion == 0) return null;

            System.out.println("Texto de búsqueda: ");
            String texto = scanner.nextLine().toLowerCase(Locale.ROOT);

            List<Libro> resultado = libros.stream()
                    .filter(Libro::getDisponible)
                    .filter(l -> (opcion == 1 && l.getTitulo().toLowerCase(Locale.ROOT).contains(texto))
                            || opcion == 2 && l.getAutor().toLowerCase(Locale.ROOT).contains(texto))
                    .toList();

            if (resultado.isEmpty()) {
                System.out.println("No se encontraron libros disponibles.");
                continue;
            }

            for (int i = 0; i < resultado.size(); i++) {
                Libro l = resultado.get(i);
                System.out.printf("%d) %s - %s%n", i + 1, l.getTitulo(), l.getAutor());
            }

            System.out.print("Selecciona número (0 cancelar): ");
            int indiceLibro = Integer.parseInt(scanner.nextLine());

            if (indiceLibro == 0) return null;
            if (indiceLibro > 0 && indiceLibro <= resultado.size()) {
                return resultado.get(indiceLibro - 1);
            }
            System.out.println("Opción inválida, inténtalo de nuevo.");
        }
    }

    private Cliente seleccionarCliente(List<Cliente> clientes) {
        while (true) {
            System.out.print("Ingrese el ID del cliente (0 para cancelar): ");
            int id = Integer.parseInt(scanner.nextLine());

            if (id == 0) return null;
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    return c;
                }
            }
            System.out.println("Cliente no encontrado.");
        }
    }
}