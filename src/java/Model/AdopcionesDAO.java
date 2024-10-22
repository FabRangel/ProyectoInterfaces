/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Configuration.ConnectionBD;
import Interface.CrudAdopciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fgmrr
 */
public class AdopcionesDAO implements CrudAdopciones{
    ConnectionBD conexion = new ConnectionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Animalito animal = new Animalito();
    Persona persona = new Persona();
    
    @Override
    public List listar() {
        ArrayList<Adopcion> listaAdopciones = new ArrayList<>();
        String sql = "SELECT * FROM adopcion";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Adopcion adopcion = new Adopcion();
                adopcion.setAnimal_id(rs.getInt("animal_id"));
                adopcion.setPersona_id(rs.getInt("duenio_id"));
                adopcion.setFecha_adopcion(rs.getDate("fecha_adopcion"));
                listaAdopciones.add(adopcion);
            }
        } catch (Exception e) {
            System.err.println("Error de carga de datos: " + e);
        }
        return listaAdopciones;

    }

    @Override
    public Boolean agregarAdopcion(Adopcion adopcion) {
        String sql2 = "INSERT INTO adopcion(animal_id,duenio_id,fecha_adopcion)"
                + " VALUES ('" + adopcion.getAnimal_id() + "','" + adopcion.getPersona_id() + "','" + adopcion.getFecha_adopcion()+ "')";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            

        } catch (Exception e) {
            System.err.println("Error al insertar: " + e);
        }
        return false;
    }
    
}
