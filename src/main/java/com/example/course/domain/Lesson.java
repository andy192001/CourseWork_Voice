package com.example.course.domain;

import com.example.course.domain.dto.LessonInputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Time time;

    @ManyToOne()
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    public Lesson(LessonInputDto command, Coach coach){
        this.date = command.getDate();
        this.time = command.getTime();
        this.coach = coach;
    }
}
