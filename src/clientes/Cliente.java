package clientes;

import usuarios.Usuario;

public class Cliente extends Usuario {
    public Cliente(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }
}
