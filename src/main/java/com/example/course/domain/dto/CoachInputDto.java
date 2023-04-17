package com.example.course.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CoachInputDto {
    private String firstName;
    private String lastName;
    private String speciality;
    private String phone;
    private List<Long> genresId;

}
