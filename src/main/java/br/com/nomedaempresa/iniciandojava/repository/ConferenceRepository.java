package br.com.nomedaempresa.iniciandojava.repository;

import br.com.nomedaempresa.iniciandojava.model.Conference;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends ListCrudRepository<Conference, Integer> {
    public static Conference getConferenceById(Integer id) {
        return null;
    }
}
