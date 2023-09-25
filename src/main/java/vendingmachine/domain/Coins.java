package vendingmachine.domain;

import vendingmachine.constant.Coin;

import java.util.ArrayList;
import java.util.List;

public class Coins {

    private final List<Coin> coins;


    public Coins() {
        this.coins = new ArrayList<>();
    }

    public void addCoin(final Coin coin) {
        this.coins.add(coin);
    }
}
