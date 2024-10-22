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
public class Adopcion {
    private int adopcion_id;
    private int animal_id;
    private int persona_id;
    private Date fecha_adopcion;

    public Adopcion() {
    }

    public Adopcion(int adopcion_id, int animal_id, int persona_id, Date fecha_adopcion) {
        this.adopcion_id = adopcion_id;
        this.animal_id = animal_id;
        this.persona_id = persona_id;
        this.fecha_adopcion = fecha_adopcion;
    }

    public int getAdopcion_id() {
        return adopcion_id;
    }

    public void setAdopcion_id(int adopcion_id) {
        this.adopcion_id = adopcion_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public Date getFecha_adopcion() {
        return fecha_adopcion;
    }

    public void setFecha_adopcion(Date fecha_adopcion) {
        this.fecha_adopcion = fecha_adopcion;
    }


    
    
}
