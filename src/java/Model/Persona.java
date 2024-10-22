/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author fgmrr
 */
public class Persona {
    private int duenio_id;
    private String nombre;
    private String apellido;
    private String telefono;

    public Persona(int duenio_id, String nombre, String apellido, String telefono) {
        this.duenio_id = duenio_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getDuenio_id() {
        return duenio_id;
    }

    public void setDuenio_id(int duenio_id) {
        this.duenio_id = duenio_id;
    }

   

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
