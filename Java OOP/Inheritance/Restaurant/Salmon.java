import java.math.BigDecimal;

public class Salmon extends MainDish{
    public static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
