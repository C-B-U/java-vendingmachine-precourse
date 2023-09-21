package vendingmachine.constant;

public enum Constant {

    PRICE_UNIT(10);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
