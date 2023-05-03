package com.example.course.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class LessonInputDto {
    private Date date;
    private Time time;
    private Long coachId;
}
