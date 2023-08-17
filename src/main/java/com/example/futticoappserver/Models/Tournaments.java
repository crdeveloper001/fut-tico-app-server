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
@Document(collection = "Tournaments")
public class Tournaments {
   
    @Id
    private String id;
    private String tournamentOrganizer;
    private String tournamentDescription;
    private String tournamentLocation;
    private LocalDateTime tournamentStartDate;
    private LocalDateTime tournamentEndDate;
    private String tournamentAvailable;
    private String tournamentUserId;
    private String tournamentOwnerId;
}
