package br.com.nomedaempresa.iniciandojava.service.interfac;

import br.com.nomedaempresa.iniciandojava.model.Session;
import br.com.nomedaempresa.iniciandojava.model.Subscription;
import br.com.nomedaempresa.iniciandojava.model.User;

import java.util.List;

public interface InterfaceSubscriptionService {
    public Subscription addSubscription(Subscription subscription);
    public List<Subscription> getAllByUser(User user);
    public List<Subscription> getAllBySession(Session session);
}
