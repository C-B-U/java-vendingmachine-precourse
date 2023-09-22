package vendingmachine.constant;


public enum ExceptionMessage {

    NOT_EXIST_PRODUCT("존재하지 않는 상품입니다."),
    NOT_ENOUGH_MONEY("보유한 금액이 부족해 상품을 구매할 수 없습니다."),
    INVALID_UNIT("10원 단위로 입력해야합니다."),
    MIN_PRICE("상품의 가격은 100원 이상부터 입력할 수 있습니다."),
    INCORRECT_FORMAT("형식에 맞춰 입력해주십시오."),
    NOT_INTEGER("숫자로 입력해야 합니다."),;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}