package vendingmachine.controller;

import vendingmachine.domain.OwningMoney;
import vendingmachine.io.InputManager;
import vendingmachine.io.OutputView;

public class VendingMachineController {

    private final OutputView outputView;
    private final InputManager inputManager;

    public VendingMachineController() {
        this.outputView = new OutputView();
        this.inputManager = new InputManager();
    }


    public void start() {
        makeOwningMoney();
    }

    private void makeOwningMoney() {
        outputView.printOwningMoney();
        final OwningMoney owningMoney = inputManager.readOwningMoney();
    }
}
