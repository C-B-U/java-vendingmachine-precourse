package vendingmachine.domain;

import vendingmachine.constants.ErrorMessage;

public class Product {

    private static final int MIN_PRICE = 100;
    private static final int COIN_UNIT = 10;
    private final String name;
    private final int price;
    private final int amount;

    public Product(String name, int price, int amount) {
        validatePriceRule(price);
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    private static boolean isaBreakPriceRule(int price) {
        return price < MIN_PRICE || price % COIN_UNIT != 0;
    }

    private void validatePriceRule(int price) {
        if (isaBreakPriceRule(price)) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_PRICE_ERROR.getMessage());
        }
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
