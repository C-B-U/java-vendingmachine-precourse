package vendingmachine.message;

public enum ProcessMessage {
    AMOUNT_VENDING_MACHINE_HAS("자판기가 보유하고 있는 금액을 입력해 주세요.");

    final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
