package pl.edu.wszib.store.dao;

import pl.edu.wszib.store.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    boolean persistUser(User user);
}
