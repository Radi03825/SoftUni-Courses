package game_store.services.impl;

import com.example.game_store.entities.users.UserWithSellsDTO;
import game_store.repositories.UserRepository;
import game_store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSellsDTO> findAllBySellingProductsGreaterThanOne() {
        return this.userRepository.findAllBySellingProductsGreaterThanOne();
    }
}
