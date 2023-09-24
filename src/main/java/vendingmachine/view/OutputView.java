package vendingmachine.view;

import vendingmachine.Coin;
import vendingmachine.message.ProcessMessage;
import vendingmachine.message.StringElement;

import java.util.Arrays;

public class OutputView {
    private static final String INSERT_AMOUNT = "투입 금액";
    private static final String WON_UNIT = "원";

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
        printInputProductInformation();
    }

    public void printInputProductInformation() {
        printNewLine();
        System.out.println(ProcessMessage.INPUT_GOODS_INFORMATION);
    }

    public void printInputAmountForInsert() {
        printNewLine();
        System.out.println(ProcessMessage.INPUT_AMOUNT_FOR_INSERT);
    }

    public void printInsertAmount(int inputAmount) {
        printNewLine();
        System.out.println(INSERT_AMOUNT + StringElement.COLON + inputAmount + WON_UNIT);
    }
}
