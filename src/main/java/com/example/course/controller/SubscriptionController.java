package com.example.course.controller;

import com.example.course.domain.Subscription;
import com.example.course.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    public List<Subscription> getAll(){
        return subscriptionService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Subscription subscription){
        subscriptionService.save(subscription);
    }

    @PostMapping("/subscribe/{subscription_id}")
    public void subscribe(@PathVariable("subscription_id") Long id){
        subscriptionService.subscribe(id);
    }
}
