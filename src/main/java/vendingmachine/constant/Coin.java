package vendingmachine.constant;

import vendingmachine.domain.OwningMoney;

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

    public static List<Integer> getCoinByOwningMoney(final OwningMoney owningMoney) {
        return Arrays.stream(values())
                .filter(value -> value.amount <= owningMoney.getValue())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public static Coin valueOfAmount(final int amount) {
        return Arrays.stream(values())
                .filter(value -> value.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.INVALID_AMOUNT.getMessage()));
    }

    public int getAmount() {
        return this.amount;
    }
}
