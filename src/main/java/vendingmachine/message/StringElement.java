package vendingmachine.message;

public enum StringElement {
    OPEN_BRACKET("["),
    CLOSE_BRACKET("]"),
    COLON(": "),
    SEMICOLON(";"),
    COMMA(",");

    private final String element;

    StringElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }
}
