package game_store;

import com.example.game_store.entities.products.ProductWithoutBuyerDTO;
import com.example.game_store.entities.users.UserWithSellsDTO;
import com.example.game_store.services.CategoryService;
import com.example.game_store.services.ProductService;
import com.example.game_store.services.SeedService;
import com.example.game_store.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    private final Gson gson;

    @Autowired
    public ConsoleRunner(SeedService seedService, UserService userService, ProductService productService, CategoryService categoryService) {
        this.seedService = seedService;
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedService.seedAll();

        /*
        List<ProductWithoutBuyerDTO> productsInPriceRangeForSell = this.productService.getProductsInPriceRangeForSell(500, 1000);

        String json = gson.toJson(productsInPriceRangeForSell);

        System.out.println(json); */


        List<UserWithSellsDTO> allBySellingProductsGreaterThanOne = this.userService.findAllBySellingProductsGreaterThanOne();

        System.out.println();
    }
}
