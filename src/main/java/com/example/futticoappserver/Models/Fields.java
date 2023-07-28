package com.example.futticoappserver.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Fields")
public class Fields {
    @Id
    private String id;
    private String fieldName;
    private Integer fieldPhone;
    private boolean fieldAvailable;
    private String fieldLocation;
    private String fieldDescription;
    
    

}
