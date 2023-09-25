package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.OwningMoney;
import vendingmachine.io.InputManager;
import vendingmachine.io.OutputView;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final VendingMachineService vendingMachineService;

    public VendingMachineController() {
        this.outputView = new OutputView();
        this.inputManager = new InputManager();
        this.vendingMachineService = new VendingMachineService();
    }


    public void start() {
        makeOwningMoney();
    }

    private void makeOwningMoney() {
        outputView.printOwningMoney();
        final OwningMoney owningMoney = inputManager.readOwningMoney();
        final Coins coins = vendingMachineService.makeCoins(owningMoney);
        outputView.printCoins(coins);
    }
}
