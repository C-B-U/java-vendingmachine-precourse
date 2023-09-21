package vendingmachine.view;

import vendingmachine.constant.OutputMessage;
import vendingmachine.domain.Coins;

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
}
