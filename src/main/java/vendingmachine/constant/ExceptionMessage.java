package vendingmachine.constant;


public enum ExceptionMessage {

    NOT_EXIST_PRODUCT("존재하지 않는 상품입니다.");

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