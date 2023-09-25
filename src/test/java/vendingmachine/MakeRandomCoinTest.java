package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.MakeRandomCoin;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MakeRandomCoinTest {

    MakeRandomCoin makeRandomCoin = new MakeRandomCoin();

    @Test
    @DisplayName("랜덤된 Coin을 저장한다.")
    void saveRandomCoin(){
        makeRandomCoin.makeCoins(450);

        List<Integer> coins = makeRandomCoin.getRandomCoins();

        assertThat(coins).containsAnyOf(500, 100, 50, 10);
    }
}
