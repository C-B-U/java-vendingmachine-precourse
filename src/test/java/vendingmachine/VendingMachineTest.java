package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.constants.Coin;
import vendingmachine.domain.VendingMachine;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.*;
public class VendingMachineTest {

    VendingMachine vendingMachine = new VendingMachine();
    @Test
    @DisplayName("랜덤으로 생성된 동전을 확인 할 수 있다.")
    void showRandomCoins(){
        vendingMachine.saveRandomCoin(30);

        String screen  = vendingMachine.showRandomCoins();

        assertThat(screen).containsAnyOf("500원 - 0개", "100원 - 0개", "50원 - 0개", "10원 - 3개");
    }

    @Test
    @DisplayName("자판기가 잔돈을 최소의 개수로 반환할 수 있다.")
    void getMinCountChange(){
        vendingMachine.saveRandomCoin(30);
        EnumMap<Coin, Integer> changeCoins = vendingMachine.returnChange(30);

        int amount = changeCoins.get(Coin.COIN_10);

        assertThat(amount).isEqualTo(3);

    }
}
