package vendingmachine.message;

public enum StringElement {
    OPEN_BRACKET("["),
    CLOSE_BRACKET("]"),
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
