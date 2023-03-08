package game_store.entities.users;

import game_store.entities.products.Product;

import java.util.List;

public class UserWithSellsDTO {

    private String firstName;
    private String lastName;

    private List<Product> soldProducts;

    public UserWithSellsDTO(String firstName, String lastName, List<Product> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }
}
