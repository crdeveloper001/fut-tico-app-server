package com.example.futticoappserver.Interfaces;

import com.example.futticoappserver.Models.Fields;

import java.util.List;

public interface IFields {

    List<Fields> GetAllCurrentFields();
    List<Fields> SearchFieldByLocation(String location);
    Fields AddNewField(Fields field);
    Fields UpdateCurrentField(Fields update);
    String DeleteFieldSelected(String fieldId);


}
