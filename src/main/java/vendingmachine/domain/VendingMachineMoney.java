package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class VendingMachineMoney {

    private static final int MONEY_UNIT = 10;
    private static final int NO_REMAINING_MONEY = 0;
    private Integer value;

    public VendingMachineMoney(final int value) {
        validateMoneyUnit(value);
        this.value = value;
    }

    private void validateMoneyUnit(final int value) {
        if (value % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    public int getValue() {
        return this.value;
    }

    public boolean hasMoney() {
        return this.value != NO_REMAINING_MONEY;
    }

    public void minusValue(final int coin) {
        validateCoin(coin);
        this.value -= coin;
    }

    private void validateCoin(final int coin) {
        if (!isAvailableCoin(coin)) {
            throw new IllegalStateException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    public boolean isAvailableCoin(final int coin) {
        return this.value >= coin;
    }
}
