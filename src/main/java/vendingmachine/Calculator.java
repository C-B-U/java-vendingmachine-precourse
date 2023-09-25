package vendingmachine;

import java.util.EnumMap;
import java.util.Map;

public class Calculator {

    private final VendingMachine vendingMachine;
    private int inputMoney;

    public Calculator(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void receiveMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public boolean isBuyingProducts(){
        Products products = vendingMachine.getProducts();
        return products.isBuyingProducts(inputMoney) ;
    }

    public void buyProducts(String name){
        Products products = vendingMachine.getProducts();
        int productPrice = products.getProductPrice(name);
        inputMoney -= productPrice;
    }

    public String returnChange(){
        StringBuilder sb = new StringBuilder();
        EnumMap<Coin, Integer> changeCoins = vendingMachine.returnChange(inputMoney);

        for (Map.Entry<Coin, Integer> coins : changeCoins.entrySet()){
            if (coins.getValue() != 0) {
                sb.append(coins.getKey())
                        .append(ScreenElement.COIN_UNIT)
                        .append(ScreenElement.DIVISION)
                        .append(coins.getValue())
                        .append(ScreenElement.COUNT_UNIT)
                        .append("\n");
            }
        }
        return sb.toString();
    }



    public int getInputMoney() {
        return inputMoney;
    }

}
