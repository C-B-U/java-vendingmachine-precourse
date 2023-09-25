package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class Product {

    private static final int NO_QUANTITY = 0;
    private static final int ZERO_PRICE = 0;
    private final String name;
    private final Integer price;
    private Integer quantity;

    public Product(final String name, final Integer price, final Integer quantity) {
        validateNumbers(price, quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private void validateNumbers(final Integer price, final Integer quantity) {
        if (price <= ZERO_PRICE || quantity <= NO_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public boolean hasSameName(final BuyProduct buyProduct) {
        return this.name.equals(buyProduct.getName());
    }

    public void purchase() {
        validateQuantity();
        this.quantity--;
    }

    private void validateQuantity() {
        if (this.quantity <= NO_QUANTITY) {
            throw new IllegalStateException(ErrorMessage.PRODUCT_NOT_EXISTS.getMessage());
        }
    }

    public boolean hasQuantity() {
        return this.quantity > NO_QUANTITY;
    }
}
