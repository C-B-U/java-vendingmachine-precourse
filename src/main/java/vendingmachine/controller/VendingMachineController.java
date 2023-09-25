package vendingmachine.controller;

import vendingmachine.io.OutputView;

public class VendingMachineController {

    private final OutputView outputView;

    public VendingMachineController() {
        this.outputView = new OutputView();
    }


    public void start() {
        outputView.printOwningMoney();
    }
}
