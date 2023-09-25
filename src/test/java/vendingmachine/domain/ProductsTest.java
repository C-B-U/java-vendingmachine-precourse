package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import vendingmachine.constant.BuyStatus;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("제품 일급 컬렉션에서")
class ProductsTest {

    @Test
    @DisplayName("같은 이름의 제품 존재시 예외를 던진다")
    void constructor() {
        assertThatThrownBy(() -> new Products(Arrays.asList(new Product("abc", 20, 20), new Product("abc", 10, 10))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("원하는 이름의 제품이 존재하지 않으면 예외를 던진다")
    void getProduct() {
        assertThatThrownBy(() -> new Products(Arrays.asList(new Product("abc", 20, 20), new Product("def", 10, 10)))
                .getProduct(new BuyProduct("ghi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가격에 비해 UserMoney의 Amount가 낮은 경우 False를 반환한다")
    void isPurchasableWithInvalidMoney() {
        //given
        final Products products = new Products(Arrays.asList(new Product("abc", 20, 20), new Product("def", 10, 10)));

        //when
        final boolean purchasable = products.isPurchasable(new UserMoney(5));

        //then
        assertThat(purchasable).isFalse();
    }

    @Test
    @DisplayName("제품의 가격보다 큰 UserMoney의 경우 True를 반환한다")
    void isPurchasableWithValidMoney() {
        //given
        final Products products = new Products(Arrays.asList(new Product("abc", 20, 20), new Product("def", 10, 10)));

        //when
        final boolean purchasable = products.isPurchasable(new UserMoney(5));

        //then
        assertThat(purchasable).isFalse();
    }

    @Nested
    class PurchaseProduct {
        @Test
        @DisplayName("제품을 살 때 살 수 있는 제품이 없으면 FINISHED를 반환한다")
        void purchaseProductWhenNotPurchasable() {
            //given
            final Product product = new Product("abc", 2000, 20);
            final Products products = new Products(Arrays.asList(product, new Product("def", 1000, 10)));

            //when
            final BuyStatus buyStatus = products.purchaseProduct(new UserMoney(100), product);

            //then
            assertThat(buyStatus).isEqualTo(BuyStatus.FINISHED);
        }

        @Test
        @DisplayName("제품을 살 때 살 수 있는 제품이 남아있으면 CONTINUE를 반환한다")
        void purchaseProductWhenPurchasable() {
            //given
            final Product product = new Product("abc", 20, 10);
            final Products products = new Products(Arrays.asList(product, new Product("def", 10, 10)));

            //when
            final BuyStatus buyStatus = products.purchaseProduct(new UserMoney(1000), product);

            //then
            assertThat(buyStatus).isEqualTo(BuyStatus.CONTINUE);
        }

        @Test
        @DisplayName("제품을 산 후 살 수 있는 제품이 없으면 FINISHED를 반환한다")
        void purchaseProductWhenPurchasableAndFinish() {
            //given
            final Product product1 = new Product("abc", 20, 1);
            final Product product2 = new Product("def", 10, 1);
            final Products products = new Products(Arrays.asList(product1, product2));

            //when
            final BuyStatus buyStatus1 = products.purchaseProduct(new UserMoney(30), product1);
            final BuyStatus buyStatus2 = products.purchaseProduct(new UserMoney(30), product2);

            //then
            assertThat(buyStatus1).isEqualTo(BuyStatus.CONTINUE);
            assertThat(buyStatus2).isEqualTo(BuyStatus.FINISHED);
        }
    }
}
