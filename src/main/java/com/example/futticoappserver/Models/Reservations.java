package com.example.futticoappserver.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Reservations")
public class Reservations {
    @Id
    @Column(name = "Reservation_id")
    private String reservationId;

    @Column(name = "Reservation_lastName")
    private String reservationLastName;

    @Column(name = "Reservation_phone")
    private Integer reservationPhone;

    @Column(name = "Reservation_email")
    private String reservationEmail;

    @Column(name = "Reservation_fieldType")
    private String reservationFieldType;

    @Column(name = "Reservation_gameType")
    private String reservationGameType;

    @Column(name = "Reservation_date")
    private LocalDateTime reservationDate;

    @Column(name = "Reservation_userId")
    private String reservationUserId;
    @jakarta.persistence.Id
    private Long id;

    public String getReservationId() {
        return this.reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationLastName() {
        return this.reservationLastName;
    }

    public void setReservationLastName(String reservationLastName) {
        this.reservationLastName = reservationLastName;
    }

    public Integer getReservationPhone() {
        return this.reservationPhone;
    }

    public void setReservationPhone(Integer reservationPhone) {
        this.reservationPhone = reservationPhone;
    }

    public String getReservationEmail() {
        return this.reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public String getReservationFieldType() {
        return this.reservationFieldType;
    }

    public void setReservationFieldType(String reservationFieldType) {
        this.reservationFieldType = reservationFieldType;
    }

    public String getReservationGameType() {
        return this.reservationGameType;
    }

    public void setReservationGameType(String reservationGameType) {
        this.reservationGameType = reservationGameType;
    }

    public LocalDateTime getReservationDate() {
        return this.reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationUserId() {
        return this.reservationUserId;
    }

    public void setReservationUserId(String reservationUserId) {
        this.reservationUserId = reservationUserId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
