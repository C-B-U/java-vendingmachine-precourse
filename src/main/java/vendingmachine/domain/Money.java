package vendingmachine.domain;

import vendingmachine.constant.ExceptionMessage;
import vendingmachine.constant.OutputMessage;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public void pay(int price) {
        validateLeftMoney(price);
        value -= price;
    }

    public void validateLeftMoney(int price) {
        if (price > value) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_MONEY.toString());
        }
    }

    public boolean isEnoughMoney(int minPrice) {
        return value >= minPrice;
    }

    public String getInputAmount() {
        return String.format(OutputMessage.INPUT_AMOUNT.toString() , value);
    }
}
