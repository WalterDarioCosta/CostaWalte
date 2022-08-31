/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.wdc.Controller;

import com.portfolio.wdc.Dto.dtoAcerca;
import com.portfolio.wdc.Entity.Acerca;
import com.portfolio.wdc.Security.Controller.Mensaje;
import com.portfolio.wdc.Service.SAcerca;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acerca")
@CrossOrigin(origins = "https://frontendwdc.web.app")

public class CAcerca {
    
    @Autowired
    SAcerca sAcerca;
    
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acerca>> list(){
        List<Acerca> list = sAcerca.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcerca dtoacerca){
        if(!sAcerca.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sAcerca.existsByNombreE(dtoacerca.getNombreE()) && sAcerca.getByNombreE(dtoacerca.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoacerca.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Acerca acerca = sAcerca.getOne(id).get();

        acerca.setNombreE(dtoacerca.getNombreE());
        acerca.setDescripcionE(dtoacerca.getDescripcionE());

        sAcerca.save(acerca);

        return new ResponseEntity(new Mensaje("Informacion actualizada"), HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Acerca> getById(@PathVariable("id")int id){
        if(!sAcerca.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Acerca acerca = sAcerca.getOne(id).get();
        return new ResponseEntity(acerca, HttpStatus.OK);
    }
    
    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcerca dtoacerca){
        if(StringUtils.isBlank(dtoacerca.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sAcerca.existsByNombreE(dtoacerca.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Acerca acerca = new Acerca (
                dtoacerca.getNombreE(), dtoacerca.getDescripcionE()
            );
        sAcerca.save(acerca);
        return new ResponseEntity(new Mensaje("Proyecto creada"), HttpStatus.OK);

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcerca.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAcerca.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
    
}
