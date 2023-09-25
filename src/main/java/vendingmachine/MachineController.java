package vendingmachine;

public class MachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final VendingMachine vendingMachine;
    private final Calculator calculator;

    public MachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.vendingMachine = new VendingMachine();
        this.calculator = new Calculator(vendingMachine);
    }

    public void run(){
       int amountHeld = inputView.inputMachineAmountHeld();
       vendingMachine.saveRandomCoin(amountHeld);
       outputView.printMachineAmountHeld(vendingMachine.showRandomCoins());

       Products products = inputView.inputProducts();
       vendingMachine.registerProducts(products);

       calculator.receiveMoney(inputView.inputMoney(products));
       buyProducts(products);

    }

    private void buyProducts(Products products) {
        while (calculator.isBuyingProducts()){
            outputView.printCurInputMoney(calculator.getInputMoney());
            String name = inputView.inputBuyProduct(products);
            calculator.buyProducts(name);
        }
        //TODO : 잔돈 반환
    }
}
