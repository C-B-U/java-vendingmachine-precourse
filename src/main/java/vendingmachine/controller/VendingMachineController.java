package vendingmachine.controller;

import vendingmachine.domain.CoinRandomGenerator;
import vendingmachine.domain.Product;
import vendingmachine.domain.Storage;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class VendingMachineController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final CoinRandomGenerator coinGenerator = new CoinRandomGenerator();
    private final Storage storage = new Storage();

    public void start() {
        outputView.printInputAmountVendingMachineHas();
        int totalAmount = repeat(inputView::readAmountVendingMachineHas);
        coinGenerator.generate(totalAmount);
        outputView.printCoinVendingMachineHas();
        setProducts();
    }

    private void setProducts() {
        outputView.printInputProductInformation();
        List<Product> products = repeat(inputView::readProductToAdd);
    }

    private <T> T repeat(Supplier<T> inputMethod) {
        try {
            return inputMethod.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return repeat(inputMethod);
        }
    }
}
