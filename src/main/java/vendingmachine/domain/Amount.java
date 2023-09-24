package vendingmachine.domain;

import vendingmachine.message.ErrorMessage;

public class Amount {
    private static final String REGEX = "^[0-9]+$";
    private final int amount;

    public Amount(String amount) {
        validateIsDigit(amount);
        this.amount = Integer.parseInt(amount);
    }

    public void validateIsDigit(String number) {
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIGIT.toString());
        }
    }
}
