package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.view.InputValidator;


import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();
    private static final String ERROR = "[ERROR] ";

    @Test
    @DisplayName("자판기가 보유한 금액이 100원 이상 입력하지 않으면 에러가 발생한다.")
    void validateMachineAmountHeld(){
        assertThatThrownBy(() -> inputValidator.validateMachineAmountHeld("50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("자판기가 보유한 금액이 숫자가 않으면 에러가 발생한다.")
    void validateNumeric(){
        assertThatThrownBy(() -> inputValidator.validateNumeric("ㄱㄱ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("상품저장 형식이 옳지 않으면 에러가 발생한다.")
    void validateDivisionProducts(){
        assertThatThrownBy(() -> inputValidator.validateDivisionProducts("ㄱㄱ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
