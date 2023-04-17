package com.example.course.service;

import com.example.course.domain.Coach;
import com.example.course.domain.Genre;
import com.example.course.domain.dto.CoachInputDto;
import com.example.course.domain.dto.CoachOutputDto;
import com.example.course.repository.CoachRepository;
import com.example.course.repository.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    private final CoachRepository coachRepository;
    private final GenreRepository genreRepository;

    public CoachService(CoachRepository coachRepository, GenreRepository genreRepository) {
        this.coachRepository = coachRepository;
        this.genreRepository = genreRepository;
    }

    public List<CoachOutputDto> getAllCoaches(){
        return coachRepository.findAll().
                stream().map(CoachOutputDto::new).toList();
    }

    @Transactional
    public void saveCoach(CoachInputDto coachInputDto){
        List<Genre> genres = genreRepository.findAllById(coachInputDto.getGenresId());

        coachRepository.save(new Coach(coachInputDto, genres));
    }
}
