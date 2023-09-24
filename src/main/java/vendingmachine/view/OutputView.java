package vendingmachine.view;

import vendingmachine.Coin;
import vendingmachine.message.ProcessMessage;

import java.util.Arrays;

public class OutputView {
    public void printNewLine() {
        System.out.println();
    }

    public void printInputAmountVendingMachineHas() {
        System.out.println(ProcessMessage.AMOUNT_VENDING_MACHINE_HAS);
    }

    public void printExceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printCoinVendingMachineHas() {
        printNewLine();
        System.out.println(ProcessMessage.COIN_VENDING_MACHINE_HAS);
        Arrays.stream(Coin.values()).forEach(coin -> System.out.println(coin.getCount()));
    }
}
