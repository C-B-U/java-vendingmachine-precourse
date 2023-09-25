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
                    final long count = coins.stream().filter(coin -> c == coin).count();
                    return String.format(COIN_FORMAT, c.getAmount(), count);
                }).collect(Collectors.joining());
    }
}
