package br.com.nomedaempresa.iniciandojava.repository;

import br.com.nomedaempresa.iniciandojava.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
}
