package com.example.futticoappserver.Interfaces;

import com.example.futticoappserver.Models.Tournaments;

import java.util.List;

public interface ITournaments {
    List<Tournaments> GetAllCurrentTournaments();
    List<Tournaments> SearchTournamentsByLocation(String location);
    List<Tournaments> SearchTournamentsByOrganizer(String organizer);
    List<Tournaments> SearchTournamentsByAvailable(String available);
    Tournaments AddNewTournaments(Tournaments tournaments);
    Tournaments UpdateCurrentTournaments(Tournaments update);
    String DeleteTournamentsSelected(String tournamentsId);
}
