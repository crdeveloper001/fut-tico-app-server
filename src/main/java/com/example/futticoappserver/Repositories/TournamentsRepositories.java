package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Tournaments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
public interface TournamentsRepositories extends MongoRepository<Tournaments,String> {
    @Query("{tournamentLocation:'?0'}")
    List<Tournaments> FilterByLocation(String tournamentLocation);
    @Query("{tournamentOrganizer:'?0'}")
    List<Tournaments> FilterByOrganizer(String tournamentOrganizer);
    @Query("{tournamentAvailable:'?0'}")
    List<Tournaments> FilterByAvailable(String tournamentAvailable);
    
}
