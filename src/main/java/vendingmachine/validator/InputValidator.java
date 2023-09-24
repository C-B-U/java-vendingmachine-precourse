package vendingmachine.validator;

import vendingmachine.message.ErrorMessage;
import vendingmachine.message.StringElement;

public class InputValidator {
    private static final String REGEX = "^[0-9]+$";
    private static final int PRODUCT_ELEMENT_SIZE = 3;

    public void validateIsDigit(String number) {
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIGIT.toString());
        }
    }

    public void validateIsCoveredBrackets(String string) {
        if (!string.startsWith(StringElement.OPEN_BRACKET.toString())
                || !string.endsWith(StringElement.CLOSE_BRACKET.toString())) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_COVERED_BY_SQUARE_BRACKETS.toString());
        }
    }

    public void validateElementSize(String[] element) {
        if (element.length != PRODUCT_ELEMENT_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.IS_WRONG_PRODUCT_ELEMENT.toString());
        }
    }
}
