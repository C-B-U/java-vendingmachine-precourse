package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.constants.Coin;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CoinTest {

    @Test
    @DisplayName("코인 가격들을 리스트로 반환한다.")
    void getCoinPrices(){
        List<Integer> coins = Coin.coinPrices();
        assertThat(coins).contains(500, 100, 50, 10);
    }

    @Test
    @DisplayName("코인 가격에 맞는 Coin을 반환한다.")
    void getCoinByPrice(){
        Coin coin = Coin.getByAmount(500);
        assertThat(coin).isEqualTo(Coin.COIN_500);
    }
}
