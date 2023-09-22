package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.validator.InputValidator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    private static final String PRODUCT_DELIMITER = ";";
    private final InputValidator inputValidator = new InputValidator();

    public Coins readChangePrice() {
        String input = Console.readLine();
        inputValidator.validateIsNumber(input);
        return new Coins(Integer.parseInt(input));
    }

    public Products readProducts() {
        String input = Console.readLine();
        inputValidator.validateFormat(input);
        return new Products(Arrays.stream(input.split(PRODUCT_DELIMITER))
                .map(Product::new)
                .collect(Collectors.toList()));
    }

    public Money readInputAmount() {
        String input = Console.readLine();
        inputValidator.validateIsNumber(input);
        return new Money(Integer.parseInt(input));
    }

    public String readProduct() {
        return Console.readLine();
    }
}
