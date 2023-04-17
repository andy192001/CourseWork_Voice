package com.example.course.domain.dto;

import com.example.course.domain.Coach;
import com.example.course.domain.Genre;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class CoachOutputDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String speciality;
    private String phone;
    private List<Genre> genres;

    public CoachOutputDto(Coach coach){
        this.id = coach.getId();
        this.firstName = coach.getFirstName();
        this.lastName = coach.getLastName();
        this.speciality = coach.getSpeciality();
        this.phone = coach.getPhone();
        this.genres = coach.getGenreList();
    }
}
