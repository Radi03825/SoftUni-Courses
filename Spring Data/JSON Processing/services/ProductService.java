package game_store.services;

import com.example.game_store.entities.products.ProductWithoutBuyerDTO;

import java.util.List;

public interface ProductService {

    public List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSell(float from, float to);
}
