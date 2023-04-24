package com.example.course.controller;

import com.example.course.domain.dto.CoachInputDto;
import com.example.course.domain.dto.CoachOutputDto;
import com.example.course.service.CoachService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public List<CoachOutputDto> getAllCoaches(){
        return coachService.getAllCoaches();
    }

    @PostMapping
    public void addCoach(@RequestBody CoachInputDto coachInputDto){
        coachService.saveCoach(coachInputDto);
    }
}
