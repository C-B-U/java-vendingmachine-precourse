package vendingmachine.view;

import vendingmachine.constant.OutputMessage;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;

public class OutputView {

    public void printChangeMessage() {
        System.out.println(OutputMessage.READ_MACHINE_CHANGE);
    }

    public void printChange(Coins coins) {
        System.out.println(OutputMessage.CHANGE_MESSAGE);
        System.out.println(coins.getChangeCoins());
    }

    public void printProduct() {
        System.out.println(OutputMessage.READ_PRODUCT);
    }

    public void printInputAmountMessage() {
        System.out.println(OutputMessage.READ_INPUT_AMOUNT);
    }

    public void printInputAmount(Money money){
        System.out.println(money.getInputAmount());
    }

    public void printPurchaseGoods() {
        System.out.println(OutputMessage.PURCHASE_GOODS);
    }

    public void printChange(String message) {
        System.out.println(message);
    }

    public void printExceptionMessage(String message){
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }
}
