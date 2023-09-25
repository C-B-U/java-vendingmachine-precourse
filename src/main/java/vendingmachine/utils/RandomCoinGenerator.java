package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.OwningMoney;

import java.util.List;

public class RandomCoinGenerator {

    public Coins generate(final OwningMoney owningMoney) {
        final List<Integer> availableCoins = Coin.getCoinByOwningMoney(owningMoney);
        final Coins coins = new Coins();
        addCoins(owningMoney, availableCoins, coins);
        return coins;
    }

    private void addCoins(final OwningMoney owningMoney, final List<Integer> availableCoins, final Coins coins) {
        while (owningMoney.hasMoney()) {
            final int coin = Randoms.pickNumberInList(availableCoins);
            if (owningMoney.isAvailableCoin(coin)) {
                owningMoney.minusValue(coin);
                coins.addCoin(Coin.valueOfAmount(coin));
            }
        }
    }
}
