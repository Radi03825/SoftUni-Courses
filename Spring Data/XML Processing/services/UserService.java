package game_store.services;

import java.util.List;

public interface UserService {

    List<UserWithSellsDTO> findAllBySellingProductsGreaterThanOne();
}
