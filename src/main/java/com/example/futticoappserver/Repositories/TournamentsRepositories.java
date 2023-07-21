package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Tournaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TournamentsRepositories extends JpaRepository<Tournaments,String> {
    @Query("select '*' from Tournaments where tournamentLocation = :location")
    List<Tournaments> FilterByLocation(String location);
    @Query("select '*' from Tournaments where tournamentOrganizer = :organizer")
    List<Tournaments> FilterByOrganizer(String organizer);
    @Query("select '*' from Tournaments where tournamentAvailable = :available")
    List<Tournaments> FilterByAvailable(String available);
}
