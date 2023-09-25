package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class OwningMoney {

    private static final int MONEY_UNIT = 10;
    private final Integer value;

    public OwningMoney(final int value) {
        validateUnit(value);
        this.value = value;
    }

    private void validateUnit(final int value) {
        if (value % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }
}
