package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("10원 단위로 가격을 입력하지 않을 경우 예외가 발생한다.")
    void validateUnit() {
        // given
        assertThatThrownBy(() -> new Price(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("가격이 100원 이하일 경우 예외가 발생한다.")
    void validateMinPrice() {
        // given
        assertThatThrownBy(() -> new Price(30))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
