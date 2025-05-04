package administradores;

import clientes.Cliente;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class RegistrarCliente {
    private Scanner scanner;
    private int contadorId = 1;

    public RegistrarCliente(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Cliente> registrarCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        while (true){
            System.out.println("---------------- REGISTRO PARA CLIENTE ----------------");

            int id = contadorId++;

            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.next();
            scanner.next();

            System.out.print("Ingrese el correo: ");
            String correo = scanner.next();

            clientes.add(new Cliente(id, nombre, correo)) ;

            System.out.println("¿Quiere registrar más clientes?: s/n");
            char respuesta = scanner.next().toLowerCase(Locale.ROOT).charAt(0);

            if (respuesta != 's'){
                break;
            }
        }
        return clientes;
    }
}
