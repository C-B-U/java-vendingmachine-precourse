package vendingmachine.service;

import vendingmachine.constant.BuyStatus;
import vendingmachine.domain.*;
import vendingmachine.repository.VendingMachineRepository;
import vendingmachine.utils.RandomCoinGenerator;

public class VendingMachineService {

    private final VendingMachineRepository vendingMachineRepository;
    private final RandomCoinGenerator randomCoinGenerator;

    public VendingMachineService() {
        this.vendingMachineRepository = new VendingMachineRepository();
        this.randomCoinGenerator = new RandomCoinGenerator();
    }

    public Coins makeCoins(final VendingMachineMoney vendingMachineMoney) {
        final Coins coins = randomCoinGenerator.generate(vendingMachineMoney);
        return vendingMachineRepository.saveCoins(coins);
    }

    public void saveProducts(final Products products) {
        vendingMachineRepository.saveProducts(products);
    }

    public void saveUserMoney(final UserMoney userMoney) {
        vendingMachineRepository.saveUserMoney(userMoney);
    }

    public UserMoney findRemainingUserMoney() {
        return vendingMachineRepository.findUserMoney();
    }

    public BuyStatus purchaseProduct(final BuyProduct buyProduct, final UserMoney userMoney) {
        final Products products = vendingMachineRepository.findProducts();
        final Product product = products.getProduct(buyProduct);

        return products.purchaseProduct(userMoney, product);
    }

    public Coins changeMoney(final UserMoney userMoney) {
        final Coins coins = vendingMachineRepository.findCoins();
        return coins.calculateCoin(userMoney);
    }
}
