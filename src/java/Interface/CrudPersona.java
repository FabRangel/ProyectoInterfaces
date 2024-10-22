/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;


import Model.Persona;

/**
 *
 * @author fgmrr
 */
public interface CrudPersona {
    public int agregarPersona (Persona persona);
    public Persona mostrarPersona (String persona_id);
    
}
