package vendingmachine;

public enum ProgressMessage {
    INPUT_MACHINE_AMOUNT_HELD("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_AMOUNT_HELD("자판기가 보유한 동전"),
    INPUT_PRODUCTS_DETAIL("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_MONEY("투입 금액을 입력해 주세요."),
    INPUT_BUY_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
    CUR_INPUT_MONEY("투입 금액: %d원");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
