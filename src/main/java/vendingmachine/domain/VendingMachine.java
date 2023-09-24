package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private final List<Product> products = new ArrayList<>();
    private int amount;

    public void add(Product product) {
        products.add(product);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
