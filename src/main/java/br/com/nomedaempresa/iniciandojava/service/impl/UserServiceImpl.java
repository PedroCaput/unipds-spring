package br.com.nomedaempresa.iniciandojava.service.impl;

import br.com.nomedaempresa.iniciandojava.exceptions.NotFoundException;
import br.com.nomedaempresa.iniciandojava.model.User;
import br.com.nomedaempresa.iniciandojava.repository.UserRepository;
import br.com.nomedaempresa.iniciandojava.service.interfac.InterfaceUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements InterfaceUserService {
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("User " + id + " not found.")
        );
    }

    @Override
    public User getUserByEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("Email " + email + " not registered.")
        );
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
