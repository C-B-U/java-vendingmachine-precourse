package vendingmachine.domain;

import vendingmachine.constant.Coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coins {

    private static final String COIN_FORMAT = "%d원 - %d개\n";
    private final List<Coin> coins;


    public Coins() {
        this.coins = new ArrayList<>();
    }

    public void addCoin(final Coin coin) {
        this.coins.add(coin);
    }

    public String getCoinMessage() {
        return Arrays.stream(Coin.values())
                .map(c -> {
                    final long count = this.coins.stream().filter(coin -> c == coin).count();
                    return String.format(COIN_FORMAT, c.getAmount(), count);
                }).collect(Collectors.joining());
    }

    public Coins calculateCoin(final UserMoney userMoney) {
        int userMoneyAmount = userMoney.getAmount();
        return getCalculateResult(userMoneyAmount);
    }

    private Coins getCalculateResult(int userMoneyAmount) {
        final Coins result = new Coins();

        for (final Coin coin : this.coins) {
            final int coinAmount = coin.getAmount();
            if (coinAmount > userMoneyAmount) {
                continue;
            }
            userMoneyAmount -= coinAmount;
            result.addCoin(coin);
        }
        return result;
    }
}
