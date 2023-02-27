package game_store.services;

import com.example.game_store.entities.User;

public interface UserService {
    User register();

    User login();

    void logout();

    User getLoggedUser();
}
