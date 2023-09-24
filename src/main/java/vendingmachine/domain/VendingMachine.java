package vendingmachine.domain;

import vendingmachine.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private static final List<Product> products = new ArrayList<>();
    private int inputAmount;

    public static Product getProduct(String product) {
        return products.stream()
                .filter(p -> p.getName().equals(product))
                .findFirst()
                .orElse(null);
    }

    public void add(Product product) {
        products.add(product);
    }

    public static void isExist(String product) {
        products.stream().filter(p -> p.getName().equals(product))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.IS_NOT_EXIST_PRODUCT.toString()));
    }

    public void setInputAmount(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public int getInputAmount() {
        return inputAmount;
    }
}
