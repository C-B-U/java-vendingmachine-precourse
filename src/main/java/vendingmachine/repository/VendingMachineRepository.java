package vendingmachine.repository;

import vendingmachine.domain.Coins;

public class VendingMachineRepository {

    private Coins coins;

    public Coins saveCoins(final Coins coins) {
        this.coins = coins;
        return this.coins;
    }

    public Coins findCoins() {
        return this.coins;
    }
}
