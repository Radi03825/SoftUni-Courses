package game_store.repositories;

import com.example.game_store.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc
            (BigDecimal rangeFrom, BigDecimal rangeTo);
}
