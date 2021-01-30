package pl.edu.wszib.store.services;

import pl.edu.wszib.store.model.User;
import pl.edu.wszib.store.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
}
