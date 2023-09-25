package vendingmachine;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Products;

import static org.assertj.core.api.Assertions.*;

public class ProductsTest {

    private static final String ERROR = "[ERROR] ";
    Products products = new Products("[콜라,1500,20];[사이다,1000,10]");
    @Test
    @DisplayName("상품이 저장되는지 확인한다.")
    void saveProducts(){
        int price = products.getProductPrice("콜라");

        assertThat(price).isEqualTo(1500);
    }

    @Test
    @DisplayName("상품의 최저 가격보다 낮은 돈을 입력하면 에러가 발생한다..")
    void validateInputMoney(){
        assertThatThrownBy(() ->  products.validateInputMoney("500"))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("저장된 상품의 이름과 일치하지 않으면 에러가 발생한다.")
    void validateInputProductName(){
        assertThatThrownBy(() ->  products.validateInputProductName("환타"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
