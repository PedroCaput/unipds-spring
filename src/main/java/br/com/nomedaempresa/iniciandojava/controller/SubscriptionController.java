package br.com.nomedaempresa.iniciandojava.controller;

import br.com.nomedaempresa.iniciandojava.model.Session;
import br.com.nomedaempresa.iniciandojava.model.Subscription;
import br.com.nomedaempresa.iniciandojava.model.User;
import br.com.nomedaempresa.iniciandojava.service.interfac.InterfaceSubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {
    private InterfaceSubscriptionService service;

    public SubscriptionController(InterfaceSubscriptionService service){
        this.service = service;
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription){
        return ResponseEntity.status(201).body(service.addSubscription(subscription));
    }

    @GetMapping("/subscriptions/user/{userId}")
    public ResponseEntity<List<Subscription>> getByUser(@PathVariable Integer userId){
        User user = new User();
        user.setUserId(userId);
        return ResponseEntity.ok(service.getAllByUser(user));
    }

    @GetMapping("/subscriptions/session/{sessionId}")
    public ResponseEntity<List<Subscription>> getBySession(@PathVariable Integer sessionId){
        Session session = new Session();
        session.setSessionId(sessionId);
        return ResponseEntity.ok(service.getAllBySession(session));
    }
}
