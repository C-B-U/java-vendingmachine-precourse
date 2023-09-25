package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class Product {

    private static final int NO_AMOUNT = 0;
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

    public Integer getPrice() {
        return this.price;
    }

    public boolean hasSameName(final BuyProduct buyProduct) {
        return this.name.equals(buyProduct.getName());
    }

    public void purchase() {
        validateAmount();
        this.amount--;
    }

    private void validateAmount() {
        if (this.amount <= 0) {
            throw new IllegalStateException(ErrorMessage.PRODUCT_NOT_EXISTS.getMessage());
        }
    }

    public boolean hasAmount() {
        return this.amount > NO_AMOUNT;
    }
}
