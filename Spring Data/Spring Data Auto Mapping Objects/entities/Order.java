package game_store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    private User buyer;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> products;

    public Order(User buyer, List<Game> products) {
        this.buyer = buyer;
        this.products = products;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public List<Game> getProducts() {
        return products;
    }

    public void setProducts(List<Game> products) {
        this.products = products;
    }
}
