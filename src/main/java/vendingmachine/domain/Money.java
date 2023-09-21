package vendingmachine.domain;

import vendingmachine.constant.OutputMessage;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public String getInputAmount() {
        return String.format(OutputMessage.INPUT_AMOUNT.toString() , value);
    }
}
