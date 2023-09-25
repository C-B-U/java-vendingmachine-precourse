package vendingmachine;

import java.util.function.Supplier;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator();

    public Integer inputMachineAmountHeld(){
        return read(() -> {
            outputView.printInputMachineAmountHeld();
            String amount = Console.readLine();
            inputValidator.validateMachineAmountHeld(amount);
            outputView.printEnter();
            return Integer.parseInt(amount);
        });
    }

    public Products inputProducts(){
        return read(() -> {
            outputView.printInputProductsDetail();
            String products = Console.readLine();
            inputValidator.validateDivisionProducts(products);
            outputView.printEnter();
            return new Products(products);
        });
    }

    public Integer inputMoney(Products products){
        return read(() -> {
            outputView.printInputMoney();
            String money = Console.readLine();
            inputValidator.validateNumeric(money);
            products.validateInputMoney(money);
            outputView.printEnter();
            return Integer.parseInt(money);
        });
    }

    public String inputBuyProduct(Products products) {
        return read(() -> {
            outputView.printInputBuyProductName();
            String name = Console.readLine();
            products.validateInputProductName(name);
            outputView.printEnter();
            return name;
        });
    }



    private <T> T read(Supplier<T> input){
        while (true){
            try {
                return input.get();
            }catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
}
