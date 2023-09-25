package vendingmachine.io;

import vendingmachine.constant.VendingMachineMessage;

public class OutputView {

    public void printOwningMoney() {
        System.out.println(VendingMachineMessage.OWNING_MONEY.getMessage());
    }
}
