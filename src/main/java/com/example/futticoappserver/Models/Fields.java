package com.example.futticoappserver.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Fields")
public class Fields {
    @Id
    @Column(name = "Field_id")
    private String fieldId;

    @Column(name = "Field_phone")
    private Integer fieldPhone;

    @Column(name = "Field_available")
    private Byte fieldAvailable;

    @Column(name = "Field_location")
    private String fieldLocation;

    @Column(name = "Field_description")
    private String fieldDescription;
    @jakarta.persistence.Id
    private Long id;



}
