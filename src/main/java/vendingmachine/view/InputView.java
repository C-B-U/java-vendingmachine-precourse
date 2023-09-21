package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String PRODUCT_DELIMITER = ";";

    public int readChangePrice() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Product> readProducts() {
        String input = Console.readLine();
        return Arrays.stream(input.split(PRODUCT_DELIMITER))
                .map(Product::new)
                .collect(Collectors.toList());
    }
}
