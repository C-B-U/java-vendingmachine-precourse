package vendingmachine;

public class OutputView {

    public void printError(String error){
        System.out.println(error);
    }

    public void printInputMachineAmountHeld(){
        System.out.println(ProgressMessage.INPUT_MACHINE_AMOUNT_HELD);
    }

    public void printInputProductsDetail() {
        System.out.println(ProgressMessage.INPUT_PRODUCTS_DETAIL);
    }

    public void printEnter(){
        System.out.println();
    }

    public void printMachineAmountHeld(String screen){
        System.out.println(ProgressMessage.MACHINE_AMOUNT_HELD);
        System.out.println(screen);
    }
}
