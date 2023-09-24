package vendingmachine.domain;

import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printCoinVendingMachineHas();
    }
}
