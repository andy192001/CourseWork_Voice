package com.example.course.service;

import com.example.course.domain.Client;
import com.example.course.domain.Subscription;
import com.example.course.exception.SubscriptionAlreadySubscribedException;
import com.example.course.repository.ClientRepository;
import com.example.course.repository.SubscriptionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ClientRepository clientRepository;

    private Optional<Client> getCurrentClient(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client principal = (Client) authentication.getPrincipal();
        return clientRepository.findByEmail(principal.getEmail());
    }

    public List<Subscription> getAll(){
        return subscriptionRepository.findAll();
    }

    public void save(Subscription subscription){
        subscriptionRepository.save(subscription);
    }

    @Transactional
    public void subscribe(Long subscription_id){
        Client client = getCurrentClient().get();
        if(client.getSubscription() != null){
            throw new SubscriptionAlreadySubscribedException("Client already have subscription");
        }
        Subscription sub = subscriptionRepository.findById(subscription_id).get();

        client.setSubscription(sub);
        client.setAmountLessons(sub.getLessonsCount());

        clientRepository.save(client);
    }
}
