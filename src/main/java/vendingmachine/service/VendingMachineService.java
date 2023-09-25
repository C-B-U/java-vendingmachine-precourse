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

    public BuyStatus purchaseProduct(final BuyProduct buyProduct) {
        final Products products = vendingMachineRepository.findProducts();
        final Product product = products.getProduct(buyProduct);

        final UserMoney userMoney = vendingMachineRepository.findUserMoney();
        if (userMoney.hasRemainingMoney(products)) {
            userMoney.decrease(product);
            product.purchase();
            return BuyStatus.CONTINUE;
        }
        return BuyStatus.FINISHED;
    }
}
