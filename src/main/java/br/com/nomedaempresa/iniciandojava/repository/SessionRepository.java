package br.com.nomedaempresa.iniciandojava.repository;

import br.com.nomedaempresa.iniciandojava.model.Session;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends ListCrudRepository<Session, Integer> {
}
