package vendingmachine.controller;

import vendingmachine.Coin;
import vendingmachine.domain.CoinRandomGenerator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

public class VendingMachineController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final CoinRandomGenerator coinGenerator = new CoinRandomGenerator();

    public void start() {
        outputView.printInputAmountVendingMachineHas();
        int totalAmount = inputView.readAmountVendingMachineHas();
        coinGenerator.generate(totalAmount);
    }
}
