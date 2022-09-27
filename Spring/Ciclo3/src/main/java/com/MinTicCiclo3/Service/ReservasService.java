package com.MinTicCiclo3.Service;

import com.MinTicCiclo3.Model.Reservas;
import com.MinTicCiclo3.Repository.ReservasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservasService {
    
    @Autowired
   private ReservasRepository reservasRepository;
    
    
    public List <Reservas> obtenerReservasCompleta(){
        return reservasRepository.obtenerReservasCompleta();
}
   
    
    public Optional <Reservas>obtenerReservasId(Integer id){
            return reservasRepository.obtenerReservasId(id);
    
    }
   
    public Reservas salvarReservas(Reservas reservas){
     if (reservas.getId()== null){
         return reservasRepository.salvarReservas(reservas);
    
     }else {
         Optional <Reservas> reservasAuxiliar = reservasRepository.obtenerReservasId(reservas.getId());
         if (reservasAuxiliar.isEmpty()){
             return reservasRepository.salvarReservas(reservas);
         }else{
             return reservas;
         }
     }
    }
    
}
