package com.MinTicCiclo3.Repository;

import com.MinTicCiclo3.Model.Reservation;
import com.MinTicCiclo3.Repository.Crud.ReservesCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservesRepository {
  @Autowired  
  private ReservesCrudRepository    reservasCrudRepository ;
  
  public List <Reservation> obtenerReservasCompleta(){
      return (List<Reservation>) reservasCrudRepository.findAll();
  }
    public Optional <Reservation> obtenerReservasId(Integer Id){
        return reservasCrudRepository.findById(Id);
    }
    public Reservation salvarReservas (Reservation reservas){
         return  reservasCrudRepository.save(reservas);
    
    }
}
