package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Product {

    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String PRODUCT_REGEX = "^\\[|\\]$";
    private static final String PRODUCT_DELIMITER = ",";
    private static final String BLANK = "";
    private static final int PURCHASE_QUANTITY = 1;

    private final String name;
    private final int price;
    private int quantity;

    public Product(String message) {
        List<String> productInformation = parseString(message);
        this.name = productInformation.get(NAME_INDEX);
        this.price = Integer.parseInt(productInformation.get(PRICE_INDEX));
        this.quantity = Integer.parseInt(productInformation.get(QUANTITY_INDEX));
    }

    private List<String> parseString(String message) {
        String product = message.replaceAll(PRODUCT_REGEX, BLANK);
        return Arrays.stream(product.split(PRODUCT_DELIMITER)).collect(Collectors.toList());
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void purchase() {
        this.quantity -= PURCHASE_QUANTITY;
    }

    public boolean isExist() {
        return quantity >= PURCHASE_QUANTITY;
    }

    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name + "\n" + price + "\n" + quantity;
    }
}
