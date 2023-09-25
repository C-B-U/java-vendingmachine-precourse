package vendingmachine.controller;

import vendingmachine.constant.BuyStatus;
import vendingmachine.domain.*;
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
        makeProduct();
        makeUserMoney();
        buyProducts();
        changeCoins();
    }

    private void changeCoins() {
        final UserMoney userMoney = vendingMachineService.findRemainingUserMoney();
        outputView.printRemainingMoney(userMoney);
        final Coins coins = vendingMachineService.changeMoney(userMoney);
        outputView.printChangeMoney(coins);
    }

    private void buyProducts() {
        while (true) {
            final UserMoney userMoney = vendingMachineService.findRemainingUserMoney();
            outputView.printBuyProductRequest(userMoney);
            final BuyProduct buyProduct = inputManager.readBuyProduct();
            final BuyStatus buyStatus = vendingMachineService.purchaseProduct(buyProduct, userMoney);
            if (buyStatus.isFinished()) {
                break;
            }
        }
    }

    private void makeUserMoney() {
        outputView.printUserMoneyRequest();
        final UserMoney userMoney = inputManager.readUserMoney();
        vendingMachineService.saveUserMoney(userMoney);
    }

    private void makeProduct() {
        outputView.printProductRequest();
        final Products products = inputManager.readProducts();
        vendingMachineService.saveProducts(products);
    }

    private void makeOwningMoney() {
        outputView.printOwningMoneyRequest();
        final OwningMoney owningMoney = inputManager.readOwningMoney();
        final Coins coins = vendingMachineService.makeCoins(owningMoney);
        outputView.printCoins(coins);
    }
}
