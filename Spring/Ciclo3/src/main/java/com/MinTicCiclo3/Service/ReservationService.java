package com.MinTicCiclo3.Service;

import com.MinTicCiclo3.Model.Reservation;
import com.MinTicCiclo3.Repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
     
     
     public List <Reservation> obtenerReservationCompleta(){
         return reservationRepository.obtenerReservationCompleta();
 }
    
     
     public Optional <Reservation>obtenerReservationId(Integer id){
             return reservationRepository.obtenerReservationId(id);
     
     }
    
     public Reservation salvarReservation(Reservation reservation){
      if (reservation.getId()== null){
          return reservationRepository.salvarReservation(reservation);
     
      }else {
          Optional <Reservation> reservationAuxiliar = reservationRepository.obtenerReservationId(reservation.getId());
          if (reservationAuxiliar.isEmpty()){
              return reservationRepository.salvarReservation(reservation);
          }else{
              return reservation;
          }
      }
     }
// JPQL

public List<Reservation> obtenerReservationCompletaJPQL() {
    return reservationRepository.obtenerReservationCompletaJPQL();
}
}
