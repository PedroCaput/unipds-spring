package br.com.nomedaempresa.iniciandojava.service.impl;

import br.com.nomedaempresa.iniciandojava.model.Session;
import br.com.nomedaempresa.iniciandojava.model.Subscription;
import br.com.nomedaempresa.iniciandojava.model.User;
import br.com.nomedaempresa.iniciandojava.repository.SubscriptionRepository;
import br.com.nomedaempresa.iniciandojava.service.interfac.InterfaceSubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements InterfaceSubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }


    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUniqueId(UUID.randomUUID().toString());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUser(User user) {
        return subscriptionRepository.findByIdUser(user);
    }

    @Override
    public List<Subscription> getAllBySession(Session session) {
        return subscriptionRepository.findByIdSession(session);
    }
}
