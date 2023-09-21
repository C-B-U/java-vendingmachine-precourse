package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    private static final String PRODUCT_DELIMITER = ";";

    public Coins readChangePrice() {
        int input = Integer.parseInt(Console.readLine());
        return new Coins(input);
    }

    public Products readProducts() {
        String input = Console.readLine();
        return new Products(Arrays.stream(input.split(PRODUCT_DELIMITER))
                .map(Product::new)
                .collect(Collectors.toList()));
    }

    public Money readInputAmount() {
        int input = Integer.parseInt(Console.readLine());
        return new Money(input);
    }

    public String readProduct() {
        return Console.readLine();
    }
}
