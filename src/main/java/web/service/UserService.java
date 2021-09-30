package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(int id);

    public void createNewUser(User user);

    public void editUserById(int id, User user);

    public void deleteUserById(int id);
}
