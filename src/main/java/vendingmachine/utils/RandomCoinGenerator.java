package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.VendingMachineMoney;

import java.util.List;

public class RandomCoinGenerator {

    public Coins generate(final VendingMachineMoney vendingMachineMoney) {
        final List<Integer> availableCoins = Coin.getCoinByVendingMachineMoney(vendingMachineMoney);
        return addCoins(vendingMachineMoney, availableCoins);
    }

    private Coins addCoins(final VendingMachineMoney vendingMachineMoney, final List<Integer> availableCoins) {
        final Coins coins = new Coins();
        while (vendingMachineMoney.hasMoney()) {
            final int coin = Randoms.pickNumberInList(availableCoins);
            if (vendingMachineMoney.isAvailableCoin(coin)) {
                vendingMachineMoney.minusValue(coin);
                coins.addCoin(Coin.valueOfAmount(coin));
            }
        }
        return coins;
    }
}
