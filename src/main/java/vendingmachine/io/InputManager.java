package vendingmachine.io;

import vendingmachine.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputManager {

    private static final String PRODUCT_DELIMITER = ";";
    private static final String FIELD_DELIMITER = ",";
    private static final int DELIMITER_INDEX = 1;
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final InputView inputView;

    public InputManager() {
        this.inputView = new InputView();
    }

    public OwningMoney readOwningMoney() {
        return read(() -> new OwningMoney(Integer.parseInt(inputView.readOwningMoney())));
    }

    public Products readProducts() {
        return read(() -> {
            final String input = inputView.readProducts();
            final List<Product> products = Arrays.stream(input.split(PRODUCT_DELIMITER))
                    .map(i -> i.substring(DELIMITER_INDEX, i.length() - DELIMITER_INDEX))
                    .map(s -> {
                        final String[] strings = s.split(FIELD_DELIMITER);
                        return new Product(
                                strings[NAME_INDEX],
                                Integer.parseInt(strings[PRICE_INDEX]),
                                Integer.parseInt(strings[QUANTITY_INDEX]));
                    }).collect(Collectors.toList());
            return new Products(products);
        });
    }

    public UserMoney readUserMoney() {
        return read(() -> new UserMoney(Integer.parseInt(inputView.readUserMoney())));
    }

    public BuyProduct readBuyProduct() {
        return read(() -> new BuyProduct(inputView.readBuyProduct()));
    }

    private <T> T read(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
