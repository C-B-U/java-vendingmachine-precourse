package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("제품 도메인에서")
class ProductTest {

    @Test
    @DisplayName("가격이 음수일 경우 생성시 예외를 던진다")
    void constructorWithMinusPrice() {
        assertThatThrownBy(() -> new Product("abc", -1, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가격이 음수일 경우 생성시 예외를 던진다")
    void constructorWithMinusQuantity() {
        assertThatThrownBy(() -> new Product("abc", 100, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void purchase() {
        assertThatThrownBy(() -> {
            final Product product = new Product("abc", 100, 1);
            product.purchase();
            product.purchase();
        }).isInstanceOf(IllegalStateException.class);
    }
}
