package com.MinTicCiclo3.Controller;


import com.MinTicCiclo3.Model.Reservas;
import com.MinTicCiclo3.Service.ReservasService;
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
public class ReservasController {
    
    
   @Autowired
   private ReservasService reservasService;
    
   @GetMapping("/reservascompleta")
   public List<Reservas> obtenerReservasCompleta(){
       return reservasService.obtenerReservasCompleta();
   }
    @GetMapping("/{id}")
   public Optional<Reservas> obtenerReservasId(@PathVariable("id") Integer identificador){
       return reservasService.obtenerReservasId(identificador);
   }
   @PostMapping("salvarreservas")
   @ResponseStatus(HttpStatus.CREATED)
   public Reservas salvarReservas(@RequestBody Reservas reservas){
       return reservasService.salvarReservas(reservas);
   }
}
