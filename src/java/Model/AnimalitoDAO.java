/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Configuration.ConnectionBD;
import Interface.CrudAnimalito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fgmrr
 */
public class AnimalitoDAO implements CrudAnimalito {

    ConnectionBD conexion = new ConnectionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Animalito animal = new Animalito();

    @Override
    public List listar() {
        ArrayList<Animalito> listaAnimales = new ArrayList<>();
        String sql = "SELECT * FROM animalitos";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Animalito animal = new Animalito();
                animal.setAnimal_id(rs.getInt("animal_id"));
                animal.setEspecie(rs.getString("especie"));
                animal.setFecha_nac(rs.getDate("fecha_nac"));
                animal.setIs_vacunado(rs.getInt("is_vacunado"));
                animal.setNombre(rs.getString("nombre"));
                animal.setPeso(rs.getFloat("peso"));
                listaAnimales.add(animal);
            }
        } catch (Exception e) {
            System.err.println("Error de carga de datos: " + e);
        }
        return listaAnimales;

    }

    @Override
    public Animalito mostrarAnimal(String animal_id) {
        String sql = "select * from animalitos where animal_id = " + animal_id;
        System.out.println(animal_id);
        Animalito animal = new Animalito();
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("hello");
                animal.setEspecie(rs.getString("especie"));
                animal.setFecha_nac(rs.getDate("fecha_nac"));
                animal.setIs_vacunado(rs.getInt("is_vacunado"));
                animal.setNombre(rs.getString("nombre"));
                animal.setPeso(rs.getFloat("peso"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return animal;
    }

    @Override
    public Boolean agregarAnimal(Animalito animal) {
        System.out.println("entraste");
        String sql2 = "INSERT INTO animalitos(especie,fecha_nac,is_vacunado,nombre,peso)"
                + " VALUES ('" + animal.getEspecie() + "','" + animal.getFecha_nac() + "','" + animal.isIs_vacunado() + "','" + animal.getNombre() + "','" + animal.getPeso() + "')";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            

        } catch (Exception e) {
            System.err.println("Error al insertar: " + e);
        }
        return false;
    }

    @Override
    public Boolean editarAnimal(Animalito animal) {
        String sql = "UPDATE animalitos SET especie = '" + animal.getEspecie()
                + "', fecha_nac = '" + animal.getFecha_nac()
                + "', is_vacunado = '" + animal.isIs_vacunado()
                + "', nombre = '" + animal.getNombre()
                + "', peso = '" + animal.getPeso()
                + "' WHERE animal_id like '" + animal.getAnimal_id() + "'";
        System.out.println("SQL: ***" + sql);
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return false;
    }

    @Override
    public Boolean borrarAnimal(String animal_id) {
        String sql = "DELETE FROM animalitos where animal_id LIKE '" + animal_id + "'";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al borrar los datos: " + e);
        }
        return false;
    }
}
