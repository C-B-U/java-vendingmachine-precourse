package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private final List<Product> products = new ArrayList<>();
    private int inputAmount;

    public void add(Product product) {
        products.add(product);
    }

    public void setInputAmount(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public int getInputAmount() {
        return inputAmount;
    }
}
