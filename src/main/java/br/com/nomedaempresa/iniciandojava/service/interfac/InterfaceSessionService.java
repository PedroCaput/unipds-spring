package br.com.nomedaempresa.iniciandojava.service.interfac;

import br.com.nomedaempresa.iniciandojava.model.Session;

import java.util.List;

public interface InterfaceSessionService {
    public Session addSession(Session session);
    public Session getSessionById(Integer id);
    public List<Session> getAllSessions();
}


