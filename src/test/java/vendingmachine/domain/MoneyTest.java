package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("남은 돈 보다 큰 돈을 내야할 경우 예외가 발생한다.")
    void validateTest() {
        Money money = new Money(1000);

        assertThatThrownBy(() -> money.pay(10000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
