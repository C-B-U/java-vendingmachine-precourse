package vendingmachine.io;

import vendingmachine.domain.OwningMoney;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.UserMoney;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputManager {

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
            final List<Product> products = Arrays.stream(input.split(";"))
                    .map(i -> i.substring(1, i.length() - 1))
                    .map(s -> {
                        final String[] strings = s.split(",");
                        return new Product(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
                    }).collect(Collectors.toList());
            return new Products(products);
        });
    }

    public UserMoney readUserMoney() {
        return read(() -> new UserMoney(Integer.parseInt(inputView.readUserMoney())));
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
