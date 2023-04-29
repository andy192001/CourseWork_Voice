package com.example.course.service;

import com.example.course.domain.Client;
import com.example.course.domain.Subscription;
import com.example.course.repository.ClientRepository;
import com.example.course.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ClientRepository clientRepository;

    public Client getClient(){
        return null;
    }

    public List<Subscription> getAll(){
        return subscriptionRepository.findAll();
    }

    public void save(Subscription subscription){
        subscriptionRepository.save(subscription);
    }

    public void subscribe(Long subscription_id){

    }
}
