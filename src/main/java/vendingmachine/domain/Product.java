package vendingmachine.domain;

import vendingmachine.message.ErrorMessage;

public class Product {
    private static final int MINIMUM_PRICE = 100;
    private static final int TEN = 10;
    private static final int MULTIPLES_OF_TEN = 0;

    private final String name;
    private final int price;
    private final int quantity;

    public Product(String name, int price, int quantity) {
        validatePrice(price);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private void validatePrice(int price) {
        if(price < MINIMUM_PRICE || price % TEN != MULTIPLES_OF_TEN) {
            throw new IllegalArgumentException(ErrorMessage.IS_WRONG_PRICE.toString());
        }
    }
}
