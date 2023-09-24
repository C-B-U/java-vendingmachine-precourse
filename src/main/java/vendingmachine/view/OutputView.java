package vendingmachine.view;

import vendingmachine.message.ProcessMessage;

public class OutputView {
    public void printInputAmountVendingMachineHas() {
        System.out.println(ProcessMessage.AMOUNT_VENDING_MACHINE_HAS);
    }

    public void printExceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
