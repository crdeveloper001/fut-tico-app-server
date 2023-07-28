package com.example.futticoappserver.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

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
    private String reservationFieldType;
    private String reservationGameType;
    private LocalDateTime reservationDate;
    private String reservationUserId;
    
}
