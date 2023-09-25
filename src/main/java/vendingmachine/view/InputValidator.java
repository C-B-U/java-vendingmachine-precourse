package vendingmachine.view;

import vendingmachine.constants.ErrorMessage;

public class InputValidator {
    private static final String NUMERIC_REGEX = "^[0-9]+$";
    private static final int MIN_MACHINE_AMOUNT_HELD = 100;
    private static final String PRODUCT_PATTERN_REGEX = "\\[[^\\[\\]]+,\\d+,\\d+\\](;\\[[^\\[\\]]+,\\d+,\\d+\\])*";

    public void validateMachineAmountHeld(String amount) {
        validateNumeric(amount);
        if (Integer.parseInt(amount) < MIN_MACHINE_AMOUNT_HELD) {
            throw new IllegalArgumentException(ErrorMessage.MIN_MACHINE_AMOUNT_HELD_ERROR.getMessage());
        }
    }

    public void validateNumeric(String amount) {
        if (!amount.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_COIN_NUMERIC_ERROR.getMessage());
        }
    }

    public void validateDivisionProducts(String products) {
        if (!products.matches(PRODUCT_PATTERN_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_REGEX_ERROR.getMessage());
        }
    }
}
