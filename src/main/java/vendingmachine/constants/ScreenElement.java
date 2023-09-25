package vendingmachine.constants;

public enum ScreenElement {
    COIN_UNIT("원"),
    DIVISION(" - "),
    COUNT_UNIT("개");

    private final String value;

    ScreenElement(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
