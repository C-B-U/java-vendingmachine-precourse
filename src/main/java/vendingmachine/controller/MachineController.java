package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;
import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private MachineService service;

    public void start() {
        service = new MachineService(readChangePrice(), readProducts(), readMoney());
    }

    private Coins readChangePrice() {
        outputView.printChangeMessage();
        Coins coins = inputView.readChangePrice();
        outputView.printChange(coins);
        return coins;
    }

    private Products readProducts() {
        outputView.printProduct();
        return inputView.readProducts();
    }

    private Money readMoney() {
        outputView.printInputAmount();
        return inputView.readInputAmount();
    }
}
