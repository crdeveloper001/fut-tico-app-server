package com.example.futticoappserver.Services;

import com.example.futticoappserver.Interfaces.ITournaments;
import com.example.futticoappserver.Models.Tournaments;
import com.example.futticoappserver.Repositories.ReservationsRepositories;
import com.example.futticoappserver.Repositories.TournamentsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class TournamentsServices implements ITournaments {

    private TournamentsRepositories repositories;

    @Override
    public List<Tournaments> GetAllCurrentTournaments() {
        return repositories.findAll();
    }

    @Override
    public List<Tournaments> SearchTournamentsByLocation(String location) {
        return repositories.FilterByLocation(location);
    }

    @Override
    public List<Tournaments> SearchTournamentsByOrganizer(String organizer) {
        return repositories.FilterByOrganizer(organizer);
    }

    @Override
    public List<Tournaments> SearchTournamentsByAvailable(String available) {
        return repositories.FilterByAvailable(available);
    }
    @Override
    public Tournaments AddNewTournaments(Tournaments tournaments) {

        try{
            if (repositories.existsById(tournaments.getTournamentId())) {

                tournaments.setTournamentId(UUID.randomUUID().toString());
                repositories.saveAndFlush(tournaments);
                return tournaments;
            }else if(!repositories.existsById(tournaments.getTournamentId())){
                return null;
            }else{
                return null;
            }
        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public Tournaments UpdateCurrentTournaments(Tournaments update) {
        try{
            if (repositories.existsById(update.getTournamentId())) {
                repositories.saveAndFlush(update);
                return update;
            }else if(!repositories.existsById(update.getTournamentId())){
                return null;
            }else{
                return null;
            }
        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public String DeleteTournamentsSelected(String tournamentsId) {
        try{
            if (repositories.existsById(tournamentsId)) {
                repositories.deleteById(tournamentsId);
                return "Torneo Eliminado";
            }else if(!repositories.existsById(tournamentsId)){
                return "Torneo no existe";
            }else{
                return "No se pudo eliminar el torneo o no existe";
            }
        }catch (Exception error){
            return error.getMessage();
        }
    }
}
