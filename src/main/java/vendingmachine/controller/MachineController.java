package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        int change = readChangePrice();
    }

    public int readChangePrice() {
        outputView.printChangeMessage();
        return inputView.readChangePrice();
    }
}
