package br.com.nomedaempresa.iniciandojava.service.interfac;

import br.com.nomedaempresa.iniciandojava.model.User;

import java.util.List;

public interface InterfaceUserService {
    public User addUser(User user);
    public User getUserById(Integer id);
    public User getUserByEmail(String email);
    public List<User> getAllUsers();
}
