package vendingmachine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static List<Integer> coinPrices() {
        return Stream.of(Coin.values())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public static Coin getByAmount(Integer coinAmount) {
        return Stream.of(Coin.values())
                .filter(coin -> coin.amount == coinAmount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_COIN.getMessage()));

    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
