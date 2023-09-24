package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.InputValidator;

public class InputView {
    private final InputValidator validator = new InputValidator();
    private final OutputView outputView = new OutputView();

    public int readAmountVendingMachineHas() {
        try {
            return convertAmountToInteger();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return readAmountVendingMachineHas();
        }
    }

    private int convertAmountToInteger() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return Integer.parseInt(input);
    }
}
