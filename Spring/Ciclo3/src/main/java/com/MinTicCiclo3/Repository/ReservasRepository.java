package com.MinTicCiclo3.Repository;

import com.MinTicCiclo3.Model.Reservas;
import com.MinTicCiclo3.Repository.Crud.ReservasCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservasRepository {
  @Autowired  
  private ReservasCrudRepository    reservasCrudRepository ;
  
  public List <Reservas> obtenerReservasCompleta(){
      return (List<Reservas>) reservasCrudRepository.findAll();
  }
    public Optional <Reservas> obtenerReservasId(Integer Id){
        return reservasCrudRepository.findById(Id);
    }
    public Reservas salvarReservas (Reservas reservas){
         return  reservasCrudRepository.save(reservas);
    
    }
}
