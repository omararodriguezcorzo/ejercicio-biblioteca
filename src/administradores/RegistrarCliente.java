package administradores;

import clientes.Cliente;
import java.util.Scanner;

public class RegistrarCliente {
    private Scanner scanner;

    public RegistrarCliente(Scanner scanner) {
        this.scanner = scanner;
    }

    public Cliente registrarCliente(){
        System.out.println("---------------- REGISTRO PARA CLIENTE ----------------");

        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.next();

        System.out.print("Ingrese el correo: ");
        String correo = scanner.next();

        Cliente cliente = new Cliente(id, nombre, correo);
        return cliente;
    }
}
