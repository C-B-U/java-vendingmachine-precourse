package vendingmachine;

public class MachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final VendingMachine vendingMachine;

    public MachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.vendingMachine = new VendingMachine();
    }

    public void run(){
       int amountHeld = inputView.inputMachineAmountHeld();
       vendingMachine.saveRandomCoin(amountHeld);
       outputView.printMachineAmountHeld(vendingMachine.showRandomCoins());
       vendingMachine.registerProducts(inputView.inputProducts());
    }
}
