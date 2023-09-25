package vendingmachine.io;

import vendingmachine.constant.VendingMachineMessage;
import vendingmachine.domain.Coins;

public class OutputView {

    public void printOwningMoneyRequest() {
        System.out.println(VendingMachineMessage.OWNING_MONEY_REQUEST.getMessage());
    }

    public void printCoins(final Coins coins) {
        System.out.println(VendingMachineMessage.OWNING_COINS.getMessage());
        System.out.println(coins.getCoinMessage());
    }

    public void printProductRequest() {
        System.out.println(VendingMachineMessage.PRODUCT_REQUEST.getMessage());
    }
}
