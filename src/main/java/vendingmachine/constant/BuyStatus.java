package vendingmachine.constant;

public enum BuyStatus {
    CONTINUE, FINISHED;

    public boolean isContinue() {
        return this == CONTINUE;
    }
}
