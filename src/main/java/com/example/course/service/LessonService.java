package com.example.course.service;

import com.example.course.domain.Client;
import com.example.course.domain.Coach;
import com.example.course.domain.Lesson;
import com.example.course.domain.dto.LessonInputDto;
import com.example.course.exception.RunOutOfLessonsException;
import com.example.course.repository.ClientRepository;
import com.example.course.repository.CoachRepository;
import com.example.course.repository.LessonRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LessonService {

    private LessonRepository lessonRepository;
    private final ClientRepository clientRepository;
    private final CoachRepository coachRepository;

    private Optional<Client> getCurrentClient(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client principal = (Client) authentication.getPrincipal();
        return clientRepository.findByEmail(principal.getEmail());
    }

    public List<Lesson> getLessons(){
        return lessonRepository.getAllUnbookedLessons();
    }

    public void addLesson(LessonInputDto command){
        Coach coach = coachRepository.findById(command.getCoachId()).get();
        Lesson lesson = new Lesson(command, coach);
        lessonRepository.save(lesson);
    }

    @Transactional
    public void bookLesson(Long lessonId){
        Client client = getCurrentClient().get();
        Lesson lesson = lessonRepository.findById(lessonId).get();

        if(client.getSubscription() == null){
            throw new RunOutOfLessonsException("Client run out of lessons");
        }

        lesson.setClient(client);
        client.setAmountLessons(client.getAmountLessons() - 1);

        if(client.getAmountLessons() == 0){
            client.setSubscription(null);
        }

        clientRepository.save(client);
        lessonRepository.save(lesson);
    }

    public void deleteLesson(Long lesson_id) {
        lessonRepository.deleteById(lesson_id);
    }
}
