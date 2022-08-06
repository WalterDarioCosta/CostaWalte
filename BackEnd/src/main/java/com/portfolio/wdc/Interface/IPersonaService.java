
package com.portfolio.wdc.Interface;



import com.portfolio.wdc.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //Traer una Persona
    public List<Persona> getPersona();
    
    //Guardar un Objeto del tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un Objeto por Id
    public void deletePersona(Long id);
    
    // Buscar persona po Id
    public Persona findPersona(Long id);

}
