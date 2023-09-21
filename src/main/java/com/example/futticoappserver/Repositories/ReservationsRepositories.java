package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Reservations;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
public interface ReservationsRepositories extends MongoRepository<Reservations,String> {
    @Query("{reservationGameType:'?0'}")
    List<Reservations> FilterByGameType(String reservationGameType);
    @Query("{reservationFieldType:'?0'}")
    List<Reservations> FilterByFieldType(String reservationFieldType);
     @Query("{reservationUserId:'?0'}")
    List<Reservations> FilterByCurrentUser(String reservationUserId);
}
