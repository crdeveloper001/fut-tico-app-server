package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Tournaments;
import com.example.futticoappserver.Models.UsersProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersProfilesRepositories extends JpaRepository<UsersProfiles,String> {
    @Query("select '*' from UsersProfiles where userRol = :rol")
    List<UsersProfiles> FilterByRol(String rol);
}
