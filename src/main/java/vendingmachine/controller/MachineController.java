package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;
import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class MachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private MachineService service;

    public void start() {
        service = new MachineService(readChangePrice(), readProducts(), readMoney());
        while (service.isOnSale()) {
            purchaseGoods();
        }
        outputView.printChange(service.calculateChange());
    }

    private Coins readChangePrice() {
        return readInput(() -> {
            outputView.printChangeMessage();
            Coins coins = inputView.readChangePrice();
            outputView.printChange(coins);
            return coins;
        });
    }

    private Products readProducts() {
        return readInput(() -> {
            outputView.printProduct();
            return inputView.readProducts();
        });
    }

    private Money readMoney() {
        return readInput(() -> {
            outputView.printInputAmountMessage();
            return inputView.readInputAmount();
        });
    }

    private void purchaseGoods() {
        outputView.printInputAmount(service.getMoney());
        outputView.printPurchaseGoods();
        service.purchaseProduct(readProduct());
    }

    private String readProduct() {
        return readInput(inputView::readProduct);
    }

    private <T> T readInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return supplier.get();
        }
    }
}
