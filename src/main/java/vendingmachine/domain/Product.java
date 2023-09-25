package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class Product {

    private final String name;
    private final Integer price;
    private Integer amount;

    public Product(final String name, final Integer price, final Integer amount) {
        validateNumbers(price, amount);
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    private void validateNumbers(final Integer price, final Integer amount) {
        if (price <= 0 || amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }
}
