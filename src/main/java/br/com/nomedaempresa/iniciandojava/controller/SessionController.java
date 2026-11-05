package br.com.nomedaempresa.iniciandojava.controller;

import br.com.nomedaempresa.iniciandojava.model.Session;
import br.com.nomedaempresa.iniciandojava.service.impl.SessionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController {
    private final SessionServiceImpl service;

    public SessionController(SessionServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<Session>> getAllSessions(){
        return ResponseEntity.ok(service.getAllSessions());
    }

    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable Integer sessionId){
        return ResponseEntity.ok(service.getSessionById(sessionId));
    }
}
