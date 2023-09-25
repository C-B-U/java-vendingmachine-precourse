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

    public void printInputMoney(){
        System.out.println(ProgressMessage.INPUT_MONEY);
    }

    public void printInputBuyProductName() {
        System.out.println(ProgressMessage.INPUT_BUY_PRODUCT_NAME);
    }

    public void printCurInputMoney(int money){
        System.out.printf((ProgressMessage.CUR_INPUT_MONEY) + "%n", money);
    }

    public void printResultChange(String returnChange) {
        System.out.println(ProgressMessage.RETURN_CHANGE);
        System.out.println(returnChange);
    }
}
