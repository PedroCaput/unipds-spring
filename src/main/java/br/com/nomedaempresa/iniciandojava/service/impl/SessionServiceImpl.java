package br.com.nomedaempresa.iniciandojava.service.impl;

import br.com.nomedaempresa.iniciandojava.exceptions.NotFoundException;
import br.com.nomedaempresa.iniciandojava.model.Session;
import br.com.nomedaempresa.iniciandojava.repository.SessionRepository;
import br.com.nomedaempresa.iniciandojava.service.interfac.InterfaceSessionService;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements InterfaceSessionService {
    private final SessionRepository repository;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Session addSession(Session session) {
        return repository.save(session);
    }

    @Override
    public Session getSessionById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Session " + id + " not found.")
        );
    }

    @Override
    public List<Session> getAllSessions() {
        return repository.findAll();
    }
}
