package vendingmachine.message;

public enum ErrorMessage {
    IS_NOT_DIGIT("금액은 숫자만 입력 가능합니다.");

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
