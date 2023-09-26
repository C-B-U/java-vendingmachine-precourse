package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> getCoinKind() {
        return Arrays.stream(Coin.values())
                .map(coin -> coin.amount)
                .sorted()
                .collect(Collectors.toList());
    }

    public static Coin getCoin(int value) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""));

    }

    public int getPrice() {
        return this.amount;
    }

    public boolean isChangeable(int price) {
        return price > this.amount;
    }

    public int calculateTotalAmount(int count) {
        return this.amount * count;
    }

    public int calculateCoinCount(int money) {
        return money % this.amount;
    }
}
