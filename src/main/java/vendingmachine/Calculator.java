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

    public boolean isBuyingProducts(){
        Products products = vendingMachine.getProducts();
        return products.isBuyingProducts(inputMoney) ;
    }

    public void buyProducts(String name){
        Products products = vendingMachine.getProducts();
        int productPrice = products.getProductPrice(name);
        inputMoney -= productPrice;
    }

    public int getInputMoney() {
        return inputMoney;
    }

}
