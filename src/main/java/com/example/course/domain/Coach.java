package com.example.course.domain;

import com.example.course.domain.dto.CoachInputDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "coach")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String speciality;

    private String phone;

    @ManyToMany
    @JoinTable(
            name = "coach_genre",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genreList = new ArrayList<>();

    public Coach(CoachInputDto command, List<Genre> genres){
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.speciality = command.getSpeciality();
        this.phone = command.getPhone();
        this.genreList = genres;
    }

//    public void addGenre(Genre genre){
//        genre.getCoachList().add(this);
//        genreList.add(genre);
//    }
}
