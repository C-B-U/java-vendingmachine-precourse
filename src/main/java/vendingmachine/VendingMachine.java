package vendingmachine;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachine {
    private final EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
    private final MakeRandomCoin makeRandomCoin = new MakeRandomCoin();
    private Products products;

    public VendingMachine() {
        for (Coin coin : Coin.values()){
            coins.put(coin, 0);
        }
    }

    public void saveRandomCoin(int amount){
        makeRandomCoin.makeCoins(amount);
        List<Integer> randomCoins = makeRandomCoin.getRandomCoins();

        coins.putAll(randomCoins.stream()
                .collect(Collectors.groupingBy(
                        Coin::getByAmount,
                        Collectors.summingInt(coinAmount -> 1)
                )));
    }

    public String showRandomCoins(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Coin, Integer> coins : coins.entrySet()){
            sb.append(coins.getKey())
                    .append(ScreenElement.COIN_UNIT)
                    .append(ScreenElement.DIVISION)
                    .append(coins.getValue())
                    .append(ScreenElement.COUNT_UNIT)
                    .append("\n");
        }
        return sb.toString();
    }

    public void registerProducts(Products products) {
        this.products = products;
    }
}
