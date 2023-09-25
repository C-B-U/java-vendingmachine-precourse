package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Constant;
import vendingmachine.constant.ExceptionMessage;
import vendingmachine.constant.OutputMessage;

import java.util.EnumMap;
import java.util.Map;

public class Coins {

    private static final int DEFAULT = 0;
    private final Map<Coin, Integer> elements;

    public Coins(int price) {
        this.elements = new EnumMap<>(Coin.class);
        validatePrice(price);
        Coin.getCoinKind()
                .forEach(value -> elements.put(Coin.getCoin(value), DEFAULT));
        createRandomCoins(price);
    }

    private void validatePrice(int price) {
        if (price % Constant.PRICE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT.toString());
        }
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

    public String getChangeCoins() {
        StringBuilder sb = new StringBuilder();
        elements.keySet()
                .forEach(value -> {
                            String message = OutputMessage.CHANGE.toString();
                            sb.append(String.format(message, value.getPrice(), elements.get(value)));
                        }
                );
        return sb.toString();
    }

    public String getChange(int money) {
        Map<Coin, Integer> change = new EnumMap<>(Coin.class);
        calculateChange(change, money);
        StringBuilder sb = new StringBuilder();
        return makeScreen(change, sb);
    }

    private void calculateChange(Map<Coin, Integer> change, int money) {
        for (Coin coin: Coin.values()) {
            int coinNumber = returnChange(coin, money, change);
            money -= coinNumber * coin.getPrice();
            if (money <= 0 || isExistChange()) {
                break;
            }
        }
    }

    private int returnChange(Coin coin, int money, Map<Coin, Integer> change) {
        int coinNumber = 0;
        if (coin.isChangeable(money)) {
            coinNumber = calculateCoinNumber(money, coin);
            elements.put(coin, elements.get(coin) - coinNumber);
            change.put(coin, coinNumber);
        }
        return coinNumber;
    }

    private String makeScreen(Map<Coin, Integer> change, StringBuilder sb) {
        change.keySet()
                .forEach(value -> {
                            String message = OutputMessage.CHANGE.toString();
                            sb.append(String.format(message, value.getPrice(), change.get(value)));
                        }
                );
        return sb.toString();
    }

    private boolean isExistChange() {
        return elements.values()
                .stream()
                .mapToInt(i -> i)
                .sum() <= 0;
    }

    private int calculateCoinNumber(int money, Coin coin) {
        int num = money % coin.getPrice();
        if (elements.get(coin) > num) {
            return elements.get(coin);
        }
        return num;
    }
}