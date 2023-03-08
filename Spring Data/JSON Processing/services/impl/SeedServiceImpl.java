package game_store.services.impl;

import com.example.game_store.entities.categories.Categories;
import com.example.game_store.entities.categories.CategoryImportDTO;
import com.example.game_store.entities.products.Product;
import com.example.game_store.entities.products.ProductImportDTO;
import com.example.game_store.entities.users.User;
import com.example.game_store.entities.users.UserImportDTO;
import game_store.repositories.CategoryRepository;
import game_store.repositories.ProductRepository;
import game_store.repositories.UserRepository;
import game_store.services.SeedService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.jfr.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        UserImportDTO[] userImportDTOS = gson.fromJson(new FileReader("Spring Data/Exam/src/main/resources/productShop/users.json"), UserImportDTO[].class);

        List<User> users = Arrays.stream(userImportDTOS).map(importDTO -> this.modelMapper.map(importDTO, User.class)).collect(Collectors.toList());

        this.userRepository.saveAll(users);

    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        ProductImportDTO[] productImportDTOS = gson.fromJson(new FileReader("Spring Data/Exam/src/main/resources/productShop/products.json"), ProductImportDTO[].class);

        List<Product> products = Arrays.stream(productImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::sendRandomCategories)
                .collect(Collectors.toList());

        this.productRepository.saveAll(products);
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        CategoryImportDTO[] categoryImportDTOS = gson.fromJson(new FileReader("Spring Data/Exam/src/main/resources/productShop/categories.json"), CategoryImportDTO[].class);
    }

    private Product sendRandomCategories(Product product) {
        Random random = new Random();
        long categoriesDbCount = this.categoryRepository.count();

        int count = random.nextInt((int) categoriesDbCount + 1);

        List<Categories> categories = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomId = random.nextInt((int) categoriesDbCount) + 1;

            Optional<Categories> randomCategory = this.categoryRepository.findById(randomId);

            categories.add(randomCategory.get());
        }

        product.setCategories(categories);
        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(944)) > 0) {
            return product;
        }

        Optional<User> buyer = getRandomUser();

        product.setBuyer(buyer.get());

        return product;
    }

    private Product setRandomSeller(Product product) {
        Optional<User> seller = getRandomUser();

        product.setSeller(seller.get());

        return product;
    }

    private Optional<User> getRandomUser() {
        long usersCount = this.userRepository.count();

        int randomUserId = new Random().nextInt((int) usersCount) + 1;

        Optional<User> seller = this.userRepository.findById(randomUserId);
        return seller;
    }
}
