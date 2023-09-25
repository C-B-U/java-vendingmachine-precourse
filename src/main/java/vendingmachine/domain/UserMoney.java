package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class UserMoney {

    private static final int NO_MONEY = 0;
    private Integer amount;

    public UserMoney(final int amount) {
        validatePositive(amount);
        this.amount = amount;
    }

    private void validatePositive(final int amount) {
        if (amount <= NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    public int getAmount() {
        return this.amount;
    }

    public void decrease(final Product product) {
        validateMoney(product.getPrice());
        this.amount -= product.getPrice();
    }

    private void validateMoney(final Integer amount) {
        if (this.amount < amount) {
            throw new IllegalStateException(ErrorMessage.NOT_ENOUGH_MONEY.getMessage());
        }
    }
}
