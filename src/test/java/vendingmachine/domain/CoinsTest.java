package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.constant.Coin;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("코인 일급컬렉션에서")
class CoinsTest {

    @Test
    @DisplayName("남은 코인 계산 과정에서 가능한 코인이 없으면 모두 0개로 표시한다")
    void calculateCoin() {
        //given
        Coins coins = new Coins();
        coins.addCoin(Coin.COIN_100);

        //when
        final Coins result = coins.calculateCoin(new UserMoney(50));

        //then
        System.out.println(result.getCoinMessage());
        assertThat(result.getCoinMessage()).contains(
                "500원 - 0개\n" +
                "100원 - 0개\n" +
                "50원 - 0개\n" +
                "10원 - 0개");
    }
}
