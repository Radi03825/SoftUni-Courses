package game_store.services.impl;

import com.example.game_store.entities.User;
import game_store.repositories.UserRepository;
import game_store.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User register() {
        return null;
    }

    @Override
    public User login() {
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public User getLoggedUser() {
        return null;
    }
}
