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
        makeVendingMachineMoney();
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
        BuyStatus buyStatus = BuyStatus.CONTINUE;

        while (buyStatus.isFinished()) {
            final UserMoney userMoney = vendingMachineService.findRemainingUserMoney();
            outputView.printBuyProductRequest(userMoney);
            final BuyProduct buyProduct = inputManager.readBuyProduct();
            buyStatus = vendingMachineService.purchaseProduct(buyProduct, userMoney);
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

    private void makeVendingMachineMoney() {
        outputView.printVendingMachineMoneyRequest();
        final VendingMachineMoney vendingMachineMoney = inputManager.readVendingMachineMoney();
        final Coins coins = vendingMachineService.makeCoins(vendingMachineMoney);
        outputView.printCoins(coins);
    }
}
