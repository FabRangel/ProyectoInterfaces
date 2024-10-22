/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Adopcion;
import java.util.List;

/**
 *
 * @author fgmrr
 */
public interface CrudAdopciones {
    public List listar();
      public Boolean agregarAdopcion (Adopcion adopcion);
}
