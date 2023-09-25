package vendingmachine.repository;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Products;

public class VendingMachineRepository {

    private Coins coins;
    private Products products;

    public Coins saveCoins(final Coins coins) {
        this.coins = coins;
        return this.coins;
    }

    public Coins findCoins() {
        return this.coins;
    }

    public void saveProducts(final Products products) {
        this.products = products;
    }

    public Products findProducts() {
        return this.products;
    }
}
