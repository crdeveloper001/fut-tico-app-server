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
@Table(name = "Tournaments")
public class Tournaments {
    @Id
    @Column(name = "Tournament_id")
    private String tournamentId;

    @Column(name = "Tournament_organizer")
    private String tournamentOrganizer;

    @Column(name = "Tournament_description")
    private String tournamentDescription;

    @Column(name = "Tournament_location")
    private String tournamentLocation;

    @Column(name = "Tournament_startDate")
    private LocalDateTime tournamentStartDate;

    @Column(name = "Tournament_endDate")
    private LocalDateTime tournamentEndDate;

    @Column(name = "Tournament_available")
    private Byte tournamentAvailable;

    @Column(name = "Tournament_userId")
    private String tournamentUserId;
    @jakarta.persistence.Id
    private Long id;

    public String getTournamentId() {
        return this.tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentOrganizer() {
        return this.tournamentOrganizer;
    }

    public void setTournamentOrganizer(String tournamentOrganizer) {
        this.tournamentOrganizer = tournamentOrganizer;
    }

    public String getTournamentDescription() {
        return this.tournamentDescription;
    }

    public void setTournamentDescription(String tournamentDescription) {
        this.tournamentDescription = tournamentDescription;
    }

    public String getTournamentLocation() {
        return this.tournamentLocation;
    }

    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public LocalDateTime getTournamentStartDate() {
        return this.tournamentStartDate;
    }

    public void setTournamentStartDate(LocalDateTime tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    public LocalDateTime getTournamentEndDate() {
        return this.tournamentEndDate;
    }

    public void setTournamentEndDate(LocalDateTime tournamentEndDate) {
        this.tournamentEndDate = tournamentEndDate;
    }

    public Byte getTournamentAvailable() {
        return this.tournamentAvailable;
    }

    public void setTournamentAvailable(Byte tournamentAvailable) {
        this.tournamentAvailable = tournamentAvailable;
    }

    public String getTournamentUserId() {
        return this.tournamentUserId;
    }

    public void setTournamentUserId(String tournamentUserId) {
        this.tournamentUserId = tournamentUserId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
