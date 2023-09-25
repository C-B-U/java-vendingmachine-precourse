package vendingmachine.constants;

public enum ErrorMessage {
    MACHINE_COIN_NUMERIC_ERROR("숫자를 입력해 주세요"),
    MIN_MACHINE_AMOUNT_HELD_ERROR("자판기 보유 금액은 최소 100원 부터 시작해주세요"),
    NOT_FOUND_COIN("존재 하지 않는 Coin 입니다."),
    PRODUCT_REGEX_ERROR("일치하지 않는 상품 형식입니다."),
    PRODUCT_PRICE_ERROR("상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 합니다."),
    INPUT_MONEY_ERROR("입력한 금액이 너무 적습니다."),
    INPUT_PRODUCT_NAME_ERROR("존재하지 않는 상품명 입니다.");


    private static final String ERROR = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
