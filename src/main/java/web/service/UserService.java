package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> getAllUsers();

    void update(User user);

    User findUserById(Long id);

    void delete(Long id);
}
