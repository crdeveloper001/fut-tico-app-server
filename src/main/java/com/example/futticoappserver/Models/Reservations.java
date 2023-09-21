package com.example.futticoappserver.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Reservations")
public class Reservations {

    @Id
    private String id;
    private String reservationName;
    private String reservationLastName;
    private Integer reservationPhone;
    private String reservationEmail;
    private Integer reservationNumberPlayers;
    private LocalDateTime reservationDate;
    private List<Fields> reservationFieldType;
    private String reservationUserId;

}
