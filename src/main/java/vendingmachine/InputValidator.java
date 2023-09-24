package vendingmachine;

public class InputValidator {
    private static final String NUMERIC_REGEX = "^[0-9]+$";
    private static final int MIN_MACHINE_AMOUNT_HELD = 100;

    public void validateMachineAmountHeld(String amount){
        validateNumeric(amount);
        if (Integer.parseInt(amount) < MIN_MACHINE_AMOUNT_HELD){
            throw new IllegalArgumentException(ErrorMessage.MIN_MACHINE_AMOUNT_HELD_ERROR.getMessage());
        }
    }

    private void validateNumeric(String amount) {
        if (!amount.matches(NUMERIC_REGEX)){
            throw new IllegalArgumentException(ErrorMessage.MACHINE_AMOUNT_HELD_NUMERIC_ERROR.getMessage());
        }
    }


}
