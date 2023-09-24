package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    final int amount;
    int count;

    Coin(final int amount, final int count) {
        this.amount = amount;
        this.count = count;
    }

    public static void addCount(int amount) {
        Arrays.stream(values())
                .filter(c -> c.amount == amount)
                .findFirst()
                .ifPresent(coin -> coin.count++);
    }
}
