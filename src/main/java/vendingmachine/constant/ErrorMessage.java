package vendingmachine.constant;

public enum ErrorMessage {
    NOT_NUMERIC("입력값은 숫자만 가능합니다."),
    INVALID_MONEY("숫자가 단위로 떨어지지 않습니다."),
    INVALID_AMOUNT("잘못된 Amount 입니다."),
    INVALID_PRODUCTS_INPUT("잘못된 Product 입력입니다."),
    NEGATIVE_NUMBER("음수는 받을 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
