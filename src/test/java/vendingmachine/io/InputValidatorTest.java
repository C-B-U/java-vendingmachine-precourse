package vendingmachine.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력값 검증 클래스에서")
class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("숫자가 아닌 입력이 들어온 경우 예외를 던진다")
    void validateNumeric() {
        assertThatThrownBy(() -> inputValidator.validateNumeric("123abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 형태와 맞지 않는 입력이 들어온 경우 예외를 던진다")
    void validateProducts() {
        assertThatThrownBy(() -> inputValidator.validateProducts("123abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
