package vendingmachine.controller;

import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.CalculatorService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final VendingMachine vendingMachine;
    private final CalculatorService calculatorService;

    public MachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.vendingMachine = new VendingMachine();
        this.calculatorService = new CalculatorService(vendingMachine);
    }

    public void run() {
        initVendingMachineAmountHeld();

        Products products = inputView.inputProducts();
        vendingMachine.registerProducts(products);

        calculatorService.receiveMoney(inputView.inputMoney(products));
        buyProducts(products);
    }

    private void initVendingMachineAmountHeld() {
        int amountHeld = inputView.inputMachineAmountHeld();
        vendingMachine.saveRandomCoin(amountHeld);
        outputView.printMachineAmountHeld(vendingMachine.showRandomCoins());
    }

    private void buyProducts(Products products) {
        while (true) {
            outputView.printCurInputMoney(calculatorService.getInputMoney());
            if (calculatorService.isBuyingProducts()) break;

            String name = inputView.inputBuyProduct(products);
            calculatorService.buyProducts(name);
        }
        outputView.printResultChange(calculatorService.returnChange());
    }
}
