package kmmx.dinamicfragments;

/**
 * Created by Gorro on 22/10/16.
 */

public class ItemPersona {

    String nombre, telefono, correo, username;

    public ItemPersona(String nombre, String telefono, String correo, String username) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
