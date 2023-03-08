package game_store.services.impl;

import com.example.game_store.entities.products.Product;
import com.example.game_store.entities.products.ProductWithAttributesDTO;
import game_store.repositories.ProductRepository;
import game_store.services.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final TypeMap<Product, ProductWithAttributesDTO> productToDtoMapping;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, TypeMap<Product, ProductWithAttributesDTO> productToDtoMapping) {
        this.productRepository = productRepository;
        this.productToDtoMapping = productToDtoMapping;
        this.mapper = new ModelMapper();
    }


    @Override
    public ExportProductsInRangeDto getInRange(float from, float to) {
        BigDecimal rangeFrom = BigDecimal.valueOf(from);
        BigDecimal rangeTo = BigDecimal.valueOf(to);

        List<Product> products = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(rangeFrom, rangeTo);

        List<ProductWithAttributesDTO> dtos =
                products
                        .stream()
                        .map(this.productToDtoMapping::map)
                        .collect(Collectors.toList());

        return new ExportProductsInRangeDto(dtos);
    }
}
