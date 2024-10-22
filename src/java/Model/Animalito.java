/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author fgmrr
 */
public class Animalito {
    private Integer animal_id;
    private String nombre;
    private String especie;
    private Date fecha_nac;
    private Float peso;
    private int is_vacunado;

    public Animalito() {
    }

    public Animalito(Integer animal_id, String nombre, String especie, Date fecha_nac, Float peso, int is_vacunado) {
        this.animal_id = animal_id;
        this.nombre = nombre;
        this.especie = especie;
        this.fecha_nac = fecha_nac;
        this.peso = peso;
        this.is_vacunado = is_vacunado;
    }

    

    public Integer getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(Integer animal_id) {
        this.animal_id = animal_id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public int isIs_vacunado() {
        return is_vacunado;
    }

    public void setIs_vacunado(int is_vacunado) {
        this.is_vacunado = is_vacunado;
    }
    
    
    
}
