package vendingmachine.constant;

public enum OutputMessage {

    READ_MACHINE_CHANGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    CHANGE_MESSAGE("자판기가 보유한 동전"),
    CHANGE("%d원 - %d개\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
