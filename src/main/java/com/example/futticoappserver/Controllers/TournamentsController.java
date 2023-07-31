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

import com.example.futticoappserver.Models.Tournaments;
import com.example.futticoappserver.Services.TournamentsServices;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/Tournaments")
public class TournamentsController {
     @Autowired
    private TournamentsServices tournaments_services;

    @GetMapping("/GetAllTournaments")
    @ResponseBody
    public ResponseEntity<List<Tournaments>> GetAllFields(){
        return new ResponseEntity<>(tournaments_services.GetAllCurrentTournaments(), HttpStatus.OK);

    }
    @GetMapping("/SearchByLocation/{location}")
    public List<Tournaments> GetAllTournamentsByLocation(@PathVariable("location") String location){
        return tournaments_services.SearchTournamentsByLocation(location);
    }
      @GetMapping("/SearchByOrganizer/{organizer}")
    public List<Tournaments> GetAllTournamentsByOrganizer(@PathVariable("organizer") String organizer){
        return tournaments_services.SearchTournamentsByOrganizer(organizer);
    }
      @GetMapping("/SearchByAvailable/{available}")
    public List<Tournaments> GetAllTournamentsByAvailable(@PathVariable("available") String available){
        return tournaments_services.SearchTournamentsByAvailable(available);
    }
    @PostMapping("/NewTournament")
    public Tournaments PostField(@RequestBody Tournaments reservation){
        return tournaments_services.AddNewTournaments(reservation);
    }
    @PutMapping("/UpdateTournament")
    public Tournaments PutField(@RequestBody Tournaments update){
        return tournaments_services.UpdateCurrentTournaments(update);
    }
    @DeleteMapping("/DeleteTournament/{id}")
    public String DeleteField(@PathVariable("id") String id){
        return tournaments_services.DeleteTournamentsSelected(id);
    }

}
