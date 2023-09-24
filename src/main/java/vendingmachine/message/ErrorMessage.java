package vendingmachine.message;

public enum ErrorMessage {
    IS_NOT_DIGIT("금액은 숫자만 입력 가능합니다."),
    IS_WRONG_PRICE("상품 가격은 100원 이상이며, 10원으로 나누어 떨어져야 합니다."),
    IS_NOT_COVERED_BY_SQUARE_BRACKETS("상품은 대괄호로 묶여있어야 합니다."),
    IS_WRONG_PRODUCT_ELEMENT("잘못된 상품 입력입니다."),
    IS_NOT_EXIST_PRODUCT("자판기에 존재하지 않는 상품입니다.");

    private static final String PREFIX = "[ERROR] ";
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
