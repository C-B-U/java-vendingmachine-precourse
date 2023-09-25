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
            sb.append(coins.getKey().toString())
                    .append(ScreenElement.COIN_UNIT)
                    .append(ScreenElement.DIVISION)
                    .append(coins.getValue())
                    .append(ScreenElement.COUNT_UNIT)
                    .append("\n");
        }
        return sb.toString();
    }

    public EnumMap<Coin, Integer> returnChange(int inputMoney){
        int remainingChange = inputMoney;
        EnumMap<Coin, Integer> changeCoins = new EnumMap<>(Coin.class);

        for (Coin coin : Coin.values()) {
            int coinValue = coin.getAmount();
            int coinCount = coins.get(coin);
            int changeCount = Math.min(coinCount, remainingChange / coinValue);

            coins.put(coin, coins.get(coin) - changeCount);
            changeCoins.put(coin, changeCount);
            remainingChange -= changeCount * coinValue;
        }
        return changeCoins;
    }

    public void registerProducts(Products products) {
        this.products = products;
    }

    public Products getProducts() {
        return products;
    }
}
