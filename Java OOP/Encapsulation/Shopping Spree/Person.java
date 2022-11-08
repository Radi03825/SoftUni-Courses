import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if(!name.trim().isEmpty())  {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        }else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {
        if(product.getCost() <= this.money) {
            products.add(product);
            this.money -= product.getCost();
        }else {
            throw new IllegalStateException(String.format("%s can't afford %s%n", this.name, product.getName()));
        }
    }

    public String getName() {
        return name;
    }

}
