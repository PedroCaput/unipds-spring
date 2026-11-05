package br.com.nomedaempresa.iniciandojava.repository;

import br.com.nomedaempresa.iniciandojava.model.Session;
import br.com.nomedaempresa.iniciandojava.model.Subscription;
import br.com.nomedaempresa.iniciandojava.model.SubscriptionId;
import br.com.nomedaempresa.iniciandojava.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends ListCrudRepository<Subscription, SubscriptionId> {
    public List<Subscription> findByIdUser(User user);
    public List<Subscription> findByIdSession(Session session);
}
