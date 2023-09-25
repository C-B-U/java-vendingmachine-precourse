package vendingmachine.io;

import vendingmachine.domain.OwningMoney;

import java.util.function.Supplier;

public class InputManager {

    private final InputView inputView;

    public InputManager() {
        this.inputView = new InputView();
    }

    public OwningMoney readOwningMoney() {
        return read(() -> new OwningMoney(Integer.parseInt(inputView.readOwningMoney())));
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
