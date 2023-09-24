package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.message.StringElement;
import vendingmachine.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String BRACKET_REGEX = "[\\[\\]]";
    private static final int PRODUCT_NAME = 0;
    private static final int PRODUCT_PRICE = 1;
    private static final int PRODUCT_COUNT = 2;
    private final InputValidator validator = new InputValidator();

    public int readAmountVendingMachineHas() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return Integer.parseInt(input);
    }

    public List<Product> readProductToAdd() {
        String input = Console.readLine();
        String[] strings = input.split(StringElement.SEMICOLON.toString());
        return Arrays.stream(strings)
                .map(this::parseProduct)
                .collect(Collectors.toList());
    }

    public int readInsertAmount() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return Integer.parseInt(input);
    }

    private Product parseProduct(String string) {
        String[] element = convertStringToArray(string);
        validator.validateIsDigit(element[PRODUCT_PRICE], element[PRODUCT_COUNT]);
        return new Product(element[PRODUCT_NAME],
                Integer.parseInt(element[PRODUCT_PRICE]),
                Integer.parseInt(element[PRODUCT_COUNT]));
    }

    private String[] convertStringToArray(String string) {
        validator.validateIsCoveredBrackets(string);
        String[] element = string.replaceAll(BRACKET_REGEX, "").split(StringElement.COMMA.toString());
        validator.validateElementSize(element);
        return element;
    }
}
