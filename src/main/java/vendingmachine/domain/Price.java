package vendingmachine.domain;

import vendingmachine.constant.Constant;
import vendingmachine.constant.ExceptionMessage;

public class Price {

    private final int value;

    public Price(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        validateUnit(value);
        validateMinPrice(value);
    }

    private void validateUnit(int value) {
        if (value % Constant.PRICE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT.toString());
        }
    }

    private void validateMinPrice(int value) {
        if (value < Constant.MIN_PRICE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.MIN_PRICE.toString());
        }
    }

    public int getValue() {
        return value;
    }
}
