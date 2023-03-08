package game_store.services;

import com.example.game_store.services.impl.ExportProductsInRangeDto;

public interface ProductService {

    ExportProductsInRangeDto getInRange(float from, float to);

}
