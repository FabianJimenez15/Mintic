package com.MinTicCiclo3.Controller;


import com.MinTicCiclo3.Model.Reservation;
import com.MinTicCiclo3.Service.ReservesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservesController {
    
    
   @Autowired
   private ReservesService reservasService;
    
   @GetMapping("/reservascompleta")
   public List<Reservation> obtenerReservasCompleta(){
       return reservasService.obtenerReservasCompleta();
   }
    @GetMapping("/{id}")
   public Optional<Reservation> obtenerReservasId(@PathVariable("id") Integer identificador){
       return reservasService.obtenerReservasId(identificador);
   }
   @PostMapping("salvarreservas")
   @ResponseStatus(HttpStatus.CREATED)
   public Reservation salvarReservas(@RequestBody Reservation reservas){
       return reservasService.salvarReservas(reservas);
   }
}
