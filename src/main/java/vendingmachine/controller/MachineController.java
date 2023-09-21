package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        new Coins(readChangePrice());
    }

    public int readChangePrice() {
        outputView.printChangeMessage();
        return inputView.readChangePrice();
    }
}
