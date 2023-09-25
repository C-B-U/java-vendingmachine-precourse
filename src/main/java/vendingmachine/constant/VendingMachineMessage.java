package vendingmachine.constant;

public enum VendingMachineMessage {

    OWNING_MONEY_REQUEST("자판기가 보유하고 있는 금액을 입력해 주세요."),
    OWNING_COINS("자판기가 보유한 동전");

    private final String message;

    VendingMachineMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
