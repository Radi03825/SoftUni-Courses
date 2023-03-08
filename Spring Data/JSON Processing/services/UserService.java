package game_store.services;

import com.example.game_store.entities.users.UserWithSellsDTO;

import java.util.List;

public interface UserService {

    List<UserWithSellsDTO> findAllBySellingProductsGreaterThanOne();
}
