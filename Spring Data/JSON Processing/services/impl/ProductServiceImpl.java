package game_store.services.impl;

import com.example.game_store.entities.products.ProductWithoutBuyerDTO;
import game_store.repositories.ProductRepository;
import game_store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSell(float from, float to) {
        BigDecimal rangeStart = BigDecimal.valueOf(from);
        BigDecimal rangeEnd = BigDecimal.valueOf(to);

        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(rangeStart, rangeEnd);
    }
}
