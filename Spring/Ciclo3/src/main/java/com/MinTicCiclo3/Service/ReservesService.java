package com.MinTicCiclo3.Service;

import com.MinTicCiclo3.Model.Reservation;
import com.MinTicCiclo3.Repository.ReservesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservesService {
    
    @Autowired
   private ReservesRepository reservasRepository;
    
    
    public List <Reservation> obtenerReservasCompleta(){
        return reservasRepository.obtenerReservasCompleta();
}
   
    
    public Optional <Reservation>obtenerReservasId(Integer id){
            return reservasRepository.obtenerReservasId(id);
    
    }
   
    public Reservation salvarReservas(Reservation reservas){
     if (reservas.getId()== null){
         return reservasRepository.salvarReservas(reservas);
    
     }else {
         Optional <Reservation> reservasAuxiliar = reservasRepository.obtenerReservasId(reservas.getId());
         if (reservasAuxiliar.isEmpty()){
             return reservasRepository.salvarReservas(reservas);
         }else{
             return reservas;
         }
     }
    }
    
}
