package vendingmachine.constant;

public enum BuyStatus {
    CONTINUE, FINISHED;

    public boolean isFinished() {
        return this ==FINISHED;
    }
}
