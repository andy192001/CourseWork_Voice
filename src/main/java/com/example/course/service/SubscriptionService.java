package com.example.course.service;

import com.example.course.domain.Client;
import com.example.course.domain.Subscription;
import com.example.course.repository.ClientRepository;
import com.example.course.repository.SubscriptionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
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

    private Optional<Client> getCurrentClientByEmail(){
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
        var client = getCurrentClientByEmail().get();
        var sub = subscriptionRepository.findById(subscription_id).get();
        client.setSubscription(sub);
        clientRepository.save(client);
    }
}
