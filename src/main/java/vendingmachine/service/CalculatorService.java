package vendingmachine.service;

import vendingmachine.constants.Coin;
import vendingmachine.constants.ScreenElement;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;

import java.util.EnumMap;
import java.util.stream.Collectors;

public class CalculatorService {

    private final VendingMachine vendingMachine;
    private int inputMoney;

    public CalculatorService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void receiveMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public boolean isBuyingProducts() {
        Products products = vendingMachine.getProducts();
        return products.isBuyingProducts(inputMoney);
    }

    public void buyProducts(String name) {
        Products products = vendingMachine.getProducts();
        int productPrice = products.getProductPrice(name);
        inputMoney -= productPrice;
    }

    public String returnChange() {
        EnumMap<Coin, Integer> changeCoins = vendingMachine.returnChange(inputMoney);

        return changeCoins.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .map(entry -> entry.getKey().toString() + ScreenElement.COIN_UNIT +
                        ScreenElement.DIVISION + entry.getValue() +
                        ScreenElement.COUNT_UNIT)
                .collect(Collectors.joining("\n"));
    }

    public int getInputMoney() {
        return inputMoney;
    }

}
