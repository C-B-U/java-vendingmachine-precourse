package vendingmachine.io;

import vendingmachine.constant.VendingMachineMessage;
import vendingmachine.domain.Coins;
import vendingmachine.domain.UserMoney;

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

    public void printUserMoneyRequest() {
        System.out.println(VendingMachineMessage.USER_MONEY_REQUEST.getMessage());
    }

    public void printBuyProductRequest(final UserMoney userMoney) {
        printRemainingMoney(userMoney);
        System.out.println(VendingMachineMessage.BUY_PRODUCT_REQUEST.getMessage());
    }

    public void printRemainingMoney(final UserMoney userMoney) {
        System.out.println(String.format(VendingMachineMessage.REMAINING_MONEY.getMessage(), userMoney.getAmount()));
    }

    public void printChangeMoney(final Coins coins) {
        System.out.println(VendingMachineMessage.CHANGE_MONEY.getMessage());
        System.out.println(coins.getCoinMessage());
    }
}
