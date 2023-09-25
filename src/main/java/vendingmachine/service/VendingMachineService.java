package vendingmachine.service;

import vendingmachine.constant.BuyStatus;
import vendingmachine.domain.*;
import vendingmachine.repository.VendingMachineRepository;
import vendingmachine.utils.RandomCoinGenerator;

public class VendingMachineService {

    private final VendingMachineRepository vendingMachineRepository;
    private final RandomCoinGenerator ranhdomCoinGenerator;

    public VendingMachineService() {
        this.vendingMachineRepository = new VendingMachineRepository();
        this.ranhdomCoinGenerator = new RandomCoinGenerator();
    }

    public Coins makeCoins(final OwningMoney owningMoney) {
        final Coins coins = ranhdomCoinGenerator.generate(owningMoney);
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

        if (products.isPurchasable(userMoney)) {
            return purchase(userMoney, product, products);
        }
        return BuyStatus.FINISHED;
    }

    private BuyStatus purchase(final UserMoney userMoney, final Product product, final Products products) {
        userMoney.decrease(product);
        product.purchase();
        if (products.isPurchasable(userMoney)) {
            return BuyStatus.CONTINUE;
        }
        return BuyStatus.FINISHED;
    }

    public Coins changeMoney(final UserMoney userMoney) {
        final Coins coins = vendingMachineRepository.findCoins();
        return coins.calculateCoin(userMoney);
    }
}
