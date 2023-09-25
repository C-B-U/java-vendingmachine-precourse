package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class UserMoney {

    private Integer amount;

    public UserMoney(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean hasRemainingMoney(final Products products) {
        return products.hasLowerPrice(this.amount);
    }

    public void decrease(final Product product) {
        validateMoney(product);
        this.amount -= product.getPrice();
    }

    private void validateMoney(final Product product) {
        if (this.amount < product.getPrice()) {
            throw new IllegalStateException(ErrorMessage.NOT_ENOUGH_MONEY.getMessage());
        }
    }
}
