package vendingmachine.service;

import vendingmachine.domain.Coins;
import vendingmachine.domain.OwningMoney;
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
}
