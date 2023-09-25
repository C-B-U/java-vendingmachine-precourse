package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("유저 잔액 도메인에서")
class UserMoneyTest {

    @Test
    @DisplayName("amount를 음수로 생성시 예외를 던진다")
    void constructor() {
        assertThatThrownBy(() -> new UserMoney(-100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잔액보다 큰 금액의 상품 구매시 예외를 던진다")
    void decrease() {
        assertThatThrownBy(() -> new UserMoney(10).decrease(new Product("123", 100, 123)))
                .isInstanceOf(IllegalStateException.class);
    }
}
