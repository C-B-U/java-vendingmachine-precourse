package vendingmachine.validator;

import vendingmachine.message.ErrorMessage;

public class InputValidator {
    private static final String REGEX = "^[0-9]+$";

    public void validateIsDigit(String number) {
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIGIT.toString());
        }
    }
}
