package vendingmachine.constant;

public enum VendingMachineMessage {

    VENDING_MACHINE_MONEY_REQUEST("자판기가 보유하고 있는 금액을 입력해 주세요."),
    VENDING_MACHINE_COINS("자판기가 보유한 동전"),
    PRODUCT_REQUEST("상품명과 가격, 수량을 입력해 주세요."),
    USER_MONEY_REQUEST("투입 금액을 입력해 주세요."),
    REMAINING_MONEY("투입 금액: %d원"),
    BUY_PRODUCT_REQUEST("구매할 상품명을 입력해 주세요."),
    CHANGE_MONEY("잔돈");

    private final String message;

    VendingMachineMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
