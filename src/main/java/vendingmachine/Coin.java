package vendingmachine;

import java.util.Arrays;

public enum Coin {
    COIN_500("500원",500, 0),
    COIN_100("100원",100, 0),
    COIN_50("50원",50, 0),
    COIN_10("10원",10, 0);

    private static final String HYPHEN = " - ";
    private static final String UNIT = "개";
    private final String tag;
    private final int amount;
    private int count;

    Coin(final String tag, final int amount, final int count) {
        this.tag = tag;
        this.amount = amount;
        this.count = count;
    }

    public static void addCount(int amount) {
        Arrays.stream(values())
                .filter(c -> c.amount == amount)
                .findFirst()
                .ifPresent(coin -> coin.count++);
    }

    public String getCount() {
        return this.tag + HYPHEN + this.count + UNIT;
    }
}
