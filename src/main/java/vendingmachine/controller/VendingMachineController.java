package vendingmachine.controller;

import vendingmachine.domain.CoinRandomGenerator;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class VendingMachineController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final CoinRandomGenerator coinGenerator = new CoinRandomGenerator();
    private final VendingMachine vendingMachine = new VendingMachine();

    public void start() {
        outputView.printInputAmountVendingMachineHas();
        coinGenerator.generate(repeat(inputView::readAmountVendingMachineHas));
        outputView.printCoinVendingMachineHas();
        setProducts();
    }

    public void setProducts() {
        repeat(inputView::readProductToAdd).forEach(vendingMachine::add);
        inputAmount();
    }

    public void inputAmount() {
        outputView.printInputAmountForInsert();
        vendingMachine.setInputAmount(repeat(inputView::readInsertAmount));
        outputView.printInsertAmount(vendingMachine.getInputAmount());
        purchaseProduct();
    }

    public void purchaseProduct() {
        outputView.printInputProductWantedPurchase();
        Product product = repeat(inputView::readProductWantedPurchase);
    }

    public <T> T repeat(Supplier<T> inputMethod) {
        try {
            return inputMethod.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return repeat(inputMethod);
        }
    }
}
