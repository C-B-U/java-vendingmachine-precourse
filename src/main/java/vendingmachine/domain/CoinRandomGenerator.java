package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.Arrays;
import java.util.List;

public class CoinRandomGenerator {
    private static final List<Integer> COINS = Arrays.asList(500, 100, 50, 10);
    private static final int MAGINOT_AMOUNT = 10;
    private static final int EXCEED_AMOUNT = 0;

    public void generate(int amount) {
        while (amount >= MAGINOT_AMOUNT) {
            amount = generateCoinByAmount(amount);
        }
    }

    private int generateCoinByAmount(int amount) {
        int pickedCoin = Randoms.pickNumberInList(COINS);
        if (amount - pickedCoin >= EXCEED_AMOUNT) {
            amount -= pickedCoin;
            Coin.addCount(pickedCoin);
        }
        return amount;
    }
}
