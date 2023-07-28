package com.example.futticoappserver.Interfaces;

import com.example.futticoappserver.Models.Reservations;

import java.util.List;

public interface IReservations {
    List<Reservations> GetAllCurrentReservation();
    List<Reservations> SearchReservationByGameType(String game);
    List<Reservations> SearchReservationByFieldType(String field);
    Reservations AddNewReservation(Reservations reservation);
    Reservations UpdateCurrentReservation(Reservations update);
    String DeleteReservationSelected(String reservationId);
}
