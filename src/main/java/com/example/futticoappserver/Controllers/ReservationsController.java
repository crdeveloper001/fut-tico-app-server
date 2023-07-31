package com.example.futticoappserver.Controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.futticoappserver.Models.Fields;
import com.example.futticoappserver.Models.Reservations;
import com.example.futticoappserver.Services.FieldsServices;
import com.example.futticoappserver.Services.ReservationsServices;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/Reservations")
public class ReservationsController {
     @Autowired
    private ReservationsServices reservations_Services;

    @GetMapping("/GetAllReservations")
    @ResponseBody
    public ResponseEntity<List<Reservations>> GetAllFields(){
        return new ResponseEntity<>(reservations_Services.GetAllCurrentReservation(), HttpStatus.OK);

    }
    @GetMapping("/SearchByGameType/{game}")
    public List<Reservations> GetAllReservationsGameType(@PathVariable("location") String game){
        return reservations_Services.SearchReservationByFieldType(game);
    }
      @GetMapping("/SearchByFieldType/{field}")
    public List<Reservations> GetAllReservationsFieldType(@PathVariable("location") String field){
        return reservations_Services.SearchReservationByFieldType(field);
    }
    @PostMapping("/NewReservation")
    public Reservations PostField(@RequestBody Reservations reservation){
        return reservations_Services.AddNewReservation(reservation);
    }
    @PutMapping("/UpdateReservation")
    public Reservations PutField(@RequestBody Reservations update){
        return reservations_Services.UpdateCurrentReservation(update);
    }
    @DeleteMapping("/DeleteReservation/{id}")
    public String DeleteField(@PathVariable("id") String id){
        return reservations_Services.DeleteReservationSelected(id);
    }

}
