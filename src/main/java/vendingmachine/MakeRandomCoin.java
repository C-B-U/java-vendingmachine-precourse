package vendingmachine;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MakeRandomCoin {
    private final List<Integer> randomCoins = new ArrayList<>();

    public void makeCoins(int amount) {
        while (isMakingRandomCoins(amount)) {
            randomCoins.add(randomCoin());
            removeOverCoin(amount);
        }
    }

    private boolean isMakingRandomCoins(int amount) {
        return getSum(randomCoins) != amount;
    }

    private int randomCoin(){
        return Randoms.pickNumberInList(Coin.coinPrices());
    }

    private void removeOverCoin(int amount) {
        if (getSum(randomCoins) > amount) {
            randomCoins.remove(randomCoins.size() - 1);
        }
    }

    private int getSum(List<Integer> coins) {
        return coins.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> getRandomCoins() {
        return randomCoins;
    }
}
