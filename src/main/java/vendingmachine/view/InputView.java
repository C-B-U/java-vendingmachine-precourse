package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Amount;
import vendingmachine.validator.InputValidator;

public class InputView {
    private final OutputView outputView = new OutputView();

    public Amount readAmountVendingMachineHas() {
        Amount amount;
        try {
            String input = Console.readLine();
            amount = new Amount(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return readAmountVendingMachineHas();
        }
        return amount;
    }
}
