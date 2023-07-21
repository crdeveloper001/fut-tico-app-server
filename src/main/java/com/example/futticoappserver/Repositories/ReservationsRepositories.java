package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationsRepositories extends JpaRepository<Reservations,String> {
    @Query("select '*' from Reservations where reservationGameType = :gameType")
    List<Reservations> FilterByGameType(String gameType);
    @Query("select '*' from Reservations where reservationFieldType = :fieldType")
    List<Reservations> FilterByFieldType(String fieldType);
}
