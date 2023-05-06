package com.example.course.controller;

import com.example.course.domain.Lesson;
import com.example.course.domain.dto.LessonInputDto;
import com.example.course.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public List<Lesson> getAllLessons(){
        return lessonService.getLessons();
    }

    @PostMapping
    public void addLesson(@RequestBody LessonInputDto command){
        lessonService.addLesson(command);
    }

    @PostMapping("/book/{lesson_id}")
    public void bookLesson(@PathVariable Long lesson_id){
        lessonService.bookLesson(lesson_id);
    }

    @DeleteMapping("/{lesson_id}")
    public void deleteLesson(@PathVariable Long lesson_id){
        lessonService.deleteLesson(lesson_id);
    }
}
