package game_store.repositories;

import com.example.game_store.entities.products.Product;
import com.example.game_store.entities.products.ProductWithoutBuyerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.example.game_store.entities.products.ProductWithoutBuyerDTO(" +
            "p.name, p.price, p.seller.firstName, p.seller.lastName)" +
            " FROM Product p" +
            " WHERE p.price > :rangeStart AND p.price < :rangeEnd AND p.buyer IS NULL" +
            " ORDER BY p.price ASC")
    List<ProductWithoutBuyerDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(
            BigDecimal rangeStart, BigDecimal rangeEnd);
}
