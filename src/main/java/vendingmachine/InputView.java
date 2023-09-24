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
