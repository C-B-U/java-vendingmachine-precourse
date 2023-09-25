package vendingmachine.domain;

public class BuyProduct {

    private final String name;

    public BuyProduct(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
