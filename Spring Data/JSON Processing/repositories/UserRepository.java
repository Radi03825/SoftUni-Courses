package game_store.repositories;

import com.example.game_store.entities.users.User;
import com.example.game_store.entities.users.UserWithSellsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT com.example.game_store.entities.users.UserWithSellsDTO(" +
            "u.firstName, u.lastName, u.sellingProducts)" +
            " FROM bosch.User u WHERE u.sellingProducts.size > 0 ORDER BY u.lastName, u.firstName")
    List<UserWithSellsDTO> findAllBySellingProductsGreaterThanOne();
}
