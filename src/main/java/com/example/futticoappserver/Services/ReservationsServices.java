package com.example.futticoappserver.Services;

import com.example.futticoappserver.Interfaces.IReservations;
import com.example.futticoappserver.Models.Reservations;
import com.example.futticoappserver.Repositories.FieldsRepositories;
import com.example.futticoappserver.Repositories.ReservationsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationsServices implements IReservations {

    private ReservationsRepositories repositories;


    @Override
    public List<Reservations> GetAllCurrentReservation() {
        return repositories.findAll();
    }

    @Override
    public List<Reservations> SearchReservationByGameType(String game) {
        return repositories.FilterByGameType(game);
    }

    @Override
    public List<Reservations> SearchReservationByFieldType(String field) {
        return repositories.FilterByFieldType(field);
    }

    @Override
    public Reservations AddNewReservation(Reservations reservation) {
       try{
           if (reservation == null) {
               reservation.setReservationId(UUID.randomUUID().toString());
               repositories.save(reservation);
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
                repositories.save(update);
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
                repositories.deleteById(reservationId);
                return "Reserva eliminada";
            }
            return "Error al eliminar reserva la reserva: "+reservationId;
        }catch (Exception error){
            throw error;
        }
    }
}
