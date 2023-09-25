package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자판기가 가지는 거스름돈 총 합 도메인에서")
class VendingMachineMoneyTest {

    @Test
    @DisplayName("최소 단위로 나눠떨어지지 않는 경우 예외를 던진다")
    void constructor() {
        assertThatThrownBy(() -> new VendingMachineMoney(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("")
    void minusValue() {
        assertThatThrownBy(() -> new VendingMachineMoney(50).minusValue(60))
                .isInstanceOf(IllegalStateException.class);
    }
}
