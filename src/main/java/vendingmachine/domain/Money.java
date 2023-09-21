package vendingmachine.domain;

import vendingmachine.constant.OutputMessage;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public void pay(int price) {
        value -= price;
    }

    public String getInputAmount() {
        return String.format(OutputMessage.INPUT_AMOUNT.toString() , value);
    }
}
