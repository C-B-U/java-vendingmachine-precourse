package vendingmachine.repository;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Products;
import vendingmachine.domain.UserMoney;

public class VendingMachineRepository {

    private Coins coins;
    private Products products;
    private UserMoney userMoney;

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

    public void saveUserMoney(final UserMoney userMoney) {
        this.userMoney = userMoney;
    }

    public UserMoney findUserMoney() {
        return this.userMoney;
    }
}
