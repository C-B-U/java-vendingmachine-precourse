package vendingmachine;

public enum ErrorMessage {
    MACHINE_AMOUNT_HELD_NUMERIC_ERROR("숫자를 입력해 주세요"),
    MIN_MACHINE_AMOUNT_HELD_ERROR("자판기 보유 금액은 최소 100원 부터 시작해주세요"),
    NOT_FOUND_COIN("존재 하지 않는 Coin 입니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
