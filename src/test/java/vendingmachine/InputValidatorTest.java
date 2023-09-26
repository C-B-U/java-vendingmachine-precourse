package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.validator.InputValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("형식에 맞추어 입력하지 않을 경우 예외 발생")
    @Test
    void formatException() {
        String input = "(콜라,1000,2)";

        assertThatThrownBy(() -> inputValidator.validateFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("숫자가 아닐 경우 예외 발생")
    @Test
    void numberException() {
        String input = "o";

        assertThatThrownBy(() -> inputValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
