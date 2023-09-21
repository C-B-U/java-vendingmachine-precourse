package vendingmachine.service;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

public class MachineService {

    private final Coins coins;
    private final Products products;
    private final Money money;

    public MachineService(Coins coins, Products products, Money money) {
        this.coins = coins;
        this.products = products;
        this.money = money;
    }

    public void purchaseProduct(String name) {
        Product product = products.findByProductName(name);
        money.pay(product.getPrice());
        product.purchase();
    }

    public boolean isOnSale() {
        return products.isExistProduct() && money.isEnoughMoney(products.getMinPrice());
    }

    public Money getMoney() {
        return money;
    }
}
