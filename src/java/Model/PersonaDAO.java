/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Configuration.ConnectionBD;
import Interface.CrudPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fgmrr
 */
public class PersonaDAO implements CrudPersona {

    ConnectionBD conexion = new ConnectionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    Persona persona = new Persona();

    @Override
    public int agregarPersona(Persona persona) {
        int idGenerado = 0;
        String sql = "INSERT INTO duenios (nombre, apellido, telefono) VALUES (?, ?, ?)";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getTelefono());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar la solicitud de adopción: " + e.getMessage());
        }
        return idGenerado;
    }
    
    public Persona mostrarPersona(String persona_id) {
        String sql = "select * from duenios where duenio_id = " + persona_id;
        Persona persona = new Persona();
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return persona;
    }

}
