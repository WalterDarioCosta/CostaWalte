
package com.portfolio.wdc.Repository;


import com.portfolio.wdc.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository  extends JpaRepository<Persona,Long>{
    
}
