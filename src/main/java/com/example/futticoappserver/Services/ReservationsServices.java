package com.example.futticoappserver.Services;

import com.example.futticoappserver.Interfaces.IReservations;
import com.example.futticoappserver.Models.Reservations;
import com.example.futticoappserver.Repositories.ReservationsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationsServices implements IReservations {
    
    @Autowired
    private ReservationsRepositories reservationsRepositories;


    @Override
    public List<Reservations> GetAllCurrentReservation() {
        return reservationsRepositories.findAll();
    }

    @Override
    public List<Reservations> SearchReservationByGameType(String game) {
        return reservationsRepositories.FilterByGameType(game);
    }

    @Override
    public List<Reservations> SearchReservationByFieldType(String field) {
        return reservationsRepositories.FilterByFieldType(field);
    }

    @Override
    public Reservations AddNewReservation(Reservations reservation) {
       try{
           if (reservation == null || reservation.getId().equals("")) {
               reservation.setId(UUID.randomUUID().toString());
               reservationsRepositories.save(reservation);
               return reservation;
           }
           return null;
       }catch (Exception error){
           throw error;
       }
    }

    @Override
    public Reservations UpdateCurrentReservation(Reservations update) {
        try{
            if (update == null) {
                reservationsRepositories.save(update);
                return update;
            }
            return null;
        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public String DeleteReservationSelected(String reservationId) {
        try{
            if (reservationId == null) {
                reservationsRepositories.deleteById(reservationId);
                return "Reserva eliminada";
            }
            return "Error al eliminar reserva la reserva: "+reservationId;
        }catch (Exception error){
            throw error;
        }
    }
}
