package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.EnumMap;
import java.util.Map;

public class Coins {

    private static final int DEFAULT = 0;
    private final Map<Coin, Integer> elements;

    public Coins(int price) {
        this.elements = new EnumMap<>(Coin.class);
        Coin.getCoinKind()
                .forEach(value -> elements.put(Coin.getCoin(value), DEFAULT));
        createRandomCoins(price);
    }

    private void createRandomCoins(int price) {
        while (price > 0) {
            int value = Randoms.pickNumberInList(Coin.getCoinKind());
            if (value <= price) {
                price -= value;
                Coin coin = Coin.getCoin(value);
                elements.put(coin, elements.get(coin)+1);
            }
        }
    }
}
