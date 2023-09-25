package vendingmachine;

public class Calculator {

    private final VendingMachine vendingMachine;
    private int inputMoney;

    public Calculator(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void receiveMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }
}
