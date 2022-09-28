package com.MinTicCiclo3.Repository;

import com.MinTicCiclo3.Model.Reservation;
import com.MinTicCiclo3.Repository.Crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    
    @Autowired  
    private ReservationCrudRepository    reservationCrudRepository ;
    
    public List <Reservation> obtenerReservationCompleta(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
      public Optional <Reservation> obtenerReservationId(Integer Id){
          return reservationCrudRepository.findById(Id);
      }
      public Reservation salvarReservation (Reservation reservation){
           return  reservationCrudRepository.save(reservation);
      
      }

      // Uso JPQL Java Persitence Query Language

    public List<Reservation> obtenerReservationCompletaJPQL() {
        return reservationCrudRepository.obtenerReservationCompletaJPQL();
    }
    
}
