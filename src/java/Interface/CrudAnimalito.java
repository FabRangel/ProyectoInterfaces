/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Animalito;
import java.util.List;

/**
 *
 * @author fgmrr
 */
public interface CrudAnimalito {
    public List listar();
    
    public Animalito mostrarAnimal(String matricula);
    
    public Boolean agregarAnimal (Animalito animal);
    
    public Boolean editarAnimal (Animalito animal);
    
    public Boolean borrarAnimal(String matricula);
}
