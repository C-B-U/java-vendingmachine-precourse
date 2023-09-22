package vendingmachine.validator;

import vendingmachine.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String FORMAT_REGEXP = "^[a-zA-Zㄱ-힣0-9,;\\[\\]]*$";
    private static final String NUMBER_REGEXP = "^\\d*$";

    public void validateFormat(String input) {
        if (!Pattern.matches(FORMAT_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_FORMAT;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    public void validateIsNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}