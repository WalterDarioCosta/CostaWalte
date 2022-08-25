/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.wdc.Service;

import com.portfolio.wdc.Entity.Acerca;
import com.portfolio.wdc.Repository.RAcerca;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcerca {
    @Autowired
    RAcerca rAcerca;
    
    public List<Acerca> list(){
         return rAcerca.findAll();
     }
     
     public Optional<Acerca> getOne(int id){
         return rAcerca.findById(id);
     }
     
     public Optional<Acerca> getByNombreE(String nombreE){
         return rAcerca.findByNombreE(nombreE);
     }
     
     public void save(Acerca expe){
         rAcerca.save(expe);
     }
     
     public void delete(int id){
         rAcerca.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rAcerca.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return rAcerca.existsByNombreE(nombreE);
     } 
}
