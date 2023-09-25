package vendingmachine.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String readVendingMachineMoney() {
        final String input = Console.readLine();
        inputValidator.validateNumeric(input);
        return input;
    }

    public String readProducts() {
        final String input = Console.readLine();
        inputValidator.validateProducts(input);
        return input;
    }

    public String readUserMoney() {
        final String input = Console.readLine();
        inputValidator.validateNumeric(input);
        return input;
    }

    public String readBuyProduct() {
        return Console.readLine();
    }
}
