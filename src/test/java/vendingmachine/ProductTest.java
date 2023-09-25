package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Product;

import static org.assertj.core.api.Assertions.*;

public class ProductTest {

    private static final String ERROR = "[ERROR] ";

    @Test
    @DisplayName("상품 가격은 100원부터 시작하며, 10원으로 나누어떨어지지 않으면 에러가 발생한다.")
    void validateProductRule(){
        assertThatThrownBy(() -> new Product("콜라", 455, 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
