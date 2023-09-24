package vendingmachine.domain;

import vendingmachine.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {
    private static final List<Product> products = new ArrayList<>();
    private int userAmount;

    public static Product getProduct(String product) {
        return products.stream()
                .filter(p -> p.getName().equals(product))
                .findFirst()
                .orElse(null);
    }

    public int getCheapestAmount() {
        List<Integer> prices = products.stream()
                .map(Product::getPrice).collect(Collectors.toList());
        return Collections.min(prices);
    }

    public void add(Product product) {
        products.add(product);
    }

    public static void isExist(String product) {
        products.stream().filter(p -> p.getName().equals(product))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.IS_NOT_EXIST_PRODUCT.toString()));
    }

    public void setUserAmount(int userAmount) {
        this.userAmount = userAmount;
    }

    public int getUserAmount() {
        return userAmount;
    }

    public boolean isPossibleToPurchase() {
        return getUserAmount() > getCheapestAmount();
    }

    public void reduceUserAmount(int producePrice) {
        this.userAmount -= producePrice;
    }
}
